package com.ai.cwf.swipeback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OneActivity.class));
            }
        });
//        ((ImageView) findViewById(R.id.next))
        Glide.with(this).load("http://img157.ph.126.net/GWifUpASa8sjBaUJPWCp_g==/1471551178244630614.jpg").into((ImageView) findViewById(R.id.next));
        setTitle("第一");
    }
}
