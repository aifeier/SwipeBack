package com.ai.cwf.swipeback;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ThereActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ThereActivity.this, ThereActivity.class));
//            }
//        });
        Glide.with(this).load("http://file25.mafengwo.net/M00/0A/AC/wKgB4lMC26CAWsKoAALb5778DWg60.rbook_comment.w1024.jpeg").into((ImageView) findViewById(R.id.next));
        setTitle("第四");
    }
}
