package com.mackwu.component.jetpack;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.mackwu.component.R;
import com.mackwu.component.base.BaseActivity;
import com.mackwu.component.bean.User;

/**
 * ===================================================
 * Created by MackWu on 2020/7/8 18:23
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 */
public class LiveDataActivity extends BaseActivity {

    private UserLiveData userLiveData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView(@Nullable final Bundle savedInstanceState) {
        findViewById(R.id.btn_test).setOnClickListener(v -> userLiveData.setValue(new User("xxx", 22)));
    }

    @Override
    public void initData(@Nullable final Bundle savedInstanceState) {
        userLiveData = UserLiveData.getInstance();
    }

}
