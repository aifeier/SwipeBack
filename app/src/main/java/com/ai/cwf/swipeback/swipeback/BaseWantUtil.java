package com.ai.cwf.swipeback.swipeback;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ai.cwf.swipeback.R;

/**
 * Created at 陈 on 2017/8/11.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class BaseWantUtil {

    private UtilUI utilUI;
    private SwipeBackActivity mActivity;

    public BaseWantUtil(SwipeBackActivity appCompatActivity) {
        mActivity = appCompatActivity;
        utilUI = UtilUI.getInstance();
    }

    /**
     * 初始化状态栏
     */
    public void initBar() {
        //透明状态栏
        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActivity.getWindow().setStatusBarColor(mActivity.getResources().getColor(R.color.colorPrimaryDark));
        }

        // 根布局顶部加上了状态栏高度的间距
        View view = ((ViewGroup) mActivity.findViewById(android.R.id.content)).getChildAt(0);
        view.setPadding(
                view.getPaddingLeft(),
                view.getPaddingTop()
                        + utilUI.getBarHeight(mActivity),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }

    /**
     * 设置沉浸TitleBar
     *
     * @param topView
     */
    public void setImmerseTitleBar(final View topView) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        // 去掉根布局顶部的状态栏高度间距
        View view = ((ViewGroup) mActivity.findViewById(android.R.id.content)).getChildAt(0);
        view.setPadding(
                view.getPaddingLeft(),
                view.getPaddingTop()
                        - utilUI.getBarHeight(mActivity),
                view.getPaddingRight(),
                view.getPaddingBottom());
        /**
         * titleBar加上状态栏高度的间距
         *
         * 这个时候Activity还在加载布局，
         * 获取控件的宽高都是0，
         * 所以要写在view.post(new Runnable() {……})里
         */
        topView.post(new Runnable() {
            @Override
            public void run() {
                View parentView = (View) topView.getParent();

                if (parentView instanceof RelativeLayout) {
                    topView.setLayoutParams(
                            new RelativeLayout.LayoutParams(
                                    -1,
                                    topView.getHeight()
                                            + utilUI.getBarHeight(mActivity)));
                } else if (parentView instanceof LinearLayout) {
                    topView.setLayoutParams(
                            new LinearLayout.LayoutParams(
                                    -1,
                                    topView.getHeight()
                                            + utilUI.getBarHeight(mActivity)));
                } else if (parentView instanceof FrameLayout) {
                    topView.setLayoutParams(
                            new FrameLayout.LayoutParams(
                                    -1,
                                    topView.getHeight()
                                            + utilUI.getBarHeight(mActivity)));
                }

                topView.setPadding(
                        topView.getPaddingLeft(),
                        topView.getPaddingTop()
                                + utilUI.getBarHeight(mActivity),
                        topView.getPaddingRight(),
                        topView.getPaddingBottom());

            }
        });
    }
}
