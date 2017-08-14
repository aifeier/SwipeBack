package com.ai.cwf.swipeback.slide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class SlidingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (enableSliding()) {
            SlidingLayout rootView = new SlidingLayout(this);
            rootView.bindActivity(this);
        }
    }

    //是否使用右滑关闭
    protected boolean enableSliding() {
        return true;
    }
}
