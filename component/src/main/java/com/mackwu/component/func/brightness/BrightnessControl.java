package com.mackwu.component.func.brightness;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/**
 * @author MackWu
 * @since 2022/6/29 15:14
 */
public class BrightnessControl {

    private static BrightnessControl instance;
    private static final int MIN_BRIGHTNESS = 30;
    private static final int MAX_BRIGHTNESS = 255;

    private BrightnessControl() {
    }

    public static BrightnessControl getInstance() {
        if (instance == null) {
            instance = new BrightnessControl();
        }
        return instance;
    }

    /**
     * 获取系统屏幕亮度值。屏幕亮度值范围（0-255）
     * 命令行：settings get system screen_brightness
     */
    private int getBrightness(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, MIN_BRIGHTNESS);
    }

    /**
     * 设置系统屏幕亮度值。
     * 例子：ScreenBrightnessUtil.setScreenBrightness(this, 10);
     * 命令行：settings put system screen_brightness 1
     *
     * @param brightness 统屏幕亮度值。屏幕亮度值范围（0-255）
     */
    private void setBrightness(Context context, int brightness) {
        setManualMode(context);
        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
    }

    /**
     * 设置手动调节屏幕亮度。手动调节屏幕亮度模式值为0。
     * 命令行：
     * settings put system screen_brightness_mode 0
     * settings get system screen_brightness_mode
     */
    public void setManualMode(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            int mode = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE);
            if (mode != Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL) {
                Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置自动调节屏幕亮度。系统会根据光感自动调节。自动调节屏幕亮度模式值为1。
     * 命令行：
     * settings put system screen_brightness_mode 1
     * settings get system screen_brightness_mode
     */
    public void setAutomaticMode(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            int mode = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE);
            if (mode != Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置自动/手动调节屏幕亮度
     */
    public void toggleAutomaticMode(Context context, boolean isAutomatic) {
        if (isAutomatic) {
            setAutomaticMode(context);
        } else {
            setManualMode(context);
        }
    }

    /**
     * 亮度是否是自动调节。1是自动调节，0是手动调节。
     */
    public boolean isAutomaticMode(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            int mode = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE);
            return mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 设置亮度进度
     *
     * @param progress 0-100
     */
    public void setBrightnessProgress(Context context, int progress) {
        int brightnessOffset = Math.round(getValidProgress(progress) * 1.0f / getBrightnessTotalProgress() * (MAX_BRIGHTNESS - MIN_BRIGHTNESS));
//        Logger.d("setBrightnessProgress...  progress=" + progress + ", brightnessOffset=" + brightnessOffset);
        setBrightness(context, brightnessOffset + MIN_BRIGHTNESS);
    }

    /**
     * 调整亮度进度
     *
     * @param context  context
     * @param progress +X/-X 如10/-10
     */
    public void adjustBrightnessProgress(Context context, int progress) {
        setBrightnessProgress(context, getBrightnessProgress(context) + progress);
    }

    /**
     * 调整亮度百分比
     *
     * @param context context
     * @param percent -1~1
     */
    public void adjustBrightnessPercent(Context context, float percent) {
        setBrightnessProgress(context, getBrightnessProgress(context) + (int) (getBrightnessTotalProgress() * getValidPercent(percent)));
    }

    /**
     * 获取亮度进度
     *
     * @param context context
     * @return 0-100
     */
    public int getBrightnessProgress(Context context) {
        int brightnessOffset = getBrightness(context) - MIN_BRIGHTNESS;
        int progress = Math.round(getValidBrightnessOffset(brightnessOffset) * 1.0f / (MAX_BRIGHTNESS - MIN_BRIGHTNESS) * getBrightnessTotalProgress());
//        Logger.d("getBrightnessProgress...  progress=" + progress + ", brightnessOffset=" + brightnessOffset);
        return getValidProgress(progress);
    }

    /**
     * 亮度总进度
     */
    public int getBrightnessTotalProgress() {
        return 100;
    }

    private int getValidProgress(int progress) {
        if (progress > getBrightnessTotalProgress()) {
            progress = getBrightnessTotalProgress();
        }
        if (progress < 0) {
            progress = 0;
        }
        return progress;
    }

    private int getValidBrightnessOffset(int brightnessOffset) {
        if (brightnessOffset < 0) {
            brightnessOffset = 0;
        }
        if (brightnessOffset > MAX_BRIGHTNESS - MIN_BRIGHTNESS) {
            brightnessOffset = MAX_BRIGHTNESS - MIN_BRIGHTNESS;
        }
        return brightnessOffset;
    }

    private float getValidPercent(float percent) {
        if (percent > 1) {
            percent = 1;
        }
        if (percent < -1) {
            percent = -1;
        }
        return percent;
    }

}