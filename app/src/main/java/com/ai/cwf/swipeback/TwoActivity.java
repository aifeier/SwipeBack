package com.ai.cwf.swipeback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ai.cwf.swipeback.swipeback.SwipeBackActivity;
import com.bumptech.glide.Glide;

public class TwoActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TwoActivity.this, ThereActivity.class));
            }
        });
        Glide.with(this).load("http://exp.cdn-hotels.com/hotels/4000000/3900000/3893200/3893187/3893187_25_y.jpg").into((ImageView) findViewById(R.id.next));
        setTitle("第三");
    }
}
