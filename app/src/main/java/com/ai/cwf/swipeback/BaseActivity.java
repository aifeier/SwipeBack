package com.ai.cwf.swipeback;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ai.cwf.swipeback.swipeback.SwipeBackActivity;

/**
 * Created at 陈 on 2017/8/11.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class BaseActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Snake.init(this);
    }
}
