package com.mackwu.media.record

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import java.io.FileOutputStream

/**
 * ===================================================
 * Created by MackWu on 2019/11/25 16:47
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 */
object AudioRecorder : Recorder {


    private val audioSource = MediaRecorder.AudioSource.MIC
    private val sampleRateInHz = 16000
    private val channelConfig = AudioFormat.CHANNEL_IN_MONO
    private val audioFormat = AudioFormat.ENCODING_PCM_16BIT
    private val bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat)
    /**
     * 初始化AudioRecord
     *
     * AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes)
     * audioSource：音频源。MediaRecorder.AudioSource.DEFAULT 默认声音、MediaRecorder.AudioSource.MIC 麦克风声音，通常用这个、MediaRecorder.AudioSource.VOICE_UPLINK 通话上行声音
     * sampleRateInHz：采样率。每秒钟能够采样的次数，采样率越高，音质越高。给出的实例是44100、22050、11025但不限于这几个参数。例如要采集低质量的音频就可以使用4000、8000等低采样率。
     * channelConfig：声道。android支持双声道立体声和单声道。AudioFormat.CHANNEL_IN_MONO单声道、AudioFormat.CHANNEL_IN_STEREO立体声
     * audioFormat：编码制式。采集来的数据使用PCM编码。android支持的采样大小16bit 或者8bit。采样大小越大，那么信息量越多，音质也越高。现在主流的采样大小都是16bit，在低质量的语音传输的时候8bit已经足够了。AudioFormat.ENCODING_PCM_16BIT、AudioFormat.ENCODING_PCM_8BIT
     * bufferSizeInBytes：采集数据缓冲区大小。AudioRecord.getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat)参数同上
     */
    private val audioRecord = AudioRecord(audioSource, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes)
    private val state = State.STOPPED

    /**
     * 开始录音
     *
     * public void startRecording()
     */
    override fun start() {
        when (state) {
            State.RECORDING -> {}
            State.STOPPED -> {}
            State.PAUSED -> {}
        }
        audioRecord.startRecording()
    }

    override fun stop() {
        audioRecord.stop()
    }

    override fun pause() {
    }

    override fun resume() {
    }

    /**
     * 从录音设备中读取音频数据
     *
     * public int read(@NonNull byte[] audioData, int offsetInBytes, int sizeInBytes)
     * audioData：音频数据写入的byte[]缓冲区
     * offsetInBytes：偏移量
     * sizeInBytes：读取大小
     */
    fun read() {
        val audioData = ByteArray(bufferSizeInBytes)
        val read = audioRecord.read(audioData, 0, bufferSizeInBytes)
        if (AudioRecord.ERROR_INVALID_OPERATION != read) {
        }
    }

}