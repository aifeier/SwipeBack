package com.ai.cwf.swipeback.swipeback;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


/**
 * Created at 陈 on 2017/8/11.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class SwipeBackActivity extends AppCompatActivity {

    private BaseGestureUtil gestureUtil;

    private static List<SwipeBackActivity> activityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureUtil = new BaseGestureUtil(this);
        activityList.add(this);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (activityList.size() > 1) {
            gestureUtil.setBeforeActivity(activityList.get(activityList.size() - 2));
        }
        gestureUtil.getGestureDetector().onTouchEvent(ev);
        if (gestureUtil.motionEvent(ev))
            return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void finish() {
        finish(true);
    }

    /**
     * 退出Activity
     *
     * @param isAnim 是否开启过渡动画
     */
    public void finish(boolean isAnim) {
        activityList.remove(this);
        super.finish();
        if (isAnim) {
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransition(0, 0);
        }
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        Log.e("test", getClass().getSimpleName() + " onPause:" + getWindow().getDecorView().getVisibility()
                + ":" + getWindow().findViewById(android.R.id.content).getVisibility());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("test", getClass().getSimpleName() + " onResume:" + getWindow().getDecorView().getVisibility()
                + ":" + getWindow().findViewById(android.R.id.content).getVisibility());
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
