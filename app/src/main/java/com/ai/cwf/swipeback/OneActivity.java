package com.ai.cwf.swipeback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class OneActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OneActivity.this, TwoActivity.class));
            }
        });
        Glide.with(this).load("http://i2.hdslb.com/video/cf/cff97285a56736d2f30dc64b6c02f88a.jpg").into((ImageView) findViewById(R.id.next));
        setTitle("第二");
    }
}
