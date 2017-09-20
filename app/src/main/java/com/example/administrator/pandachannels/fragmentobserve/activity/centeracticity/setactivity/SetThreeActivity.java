package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity.setactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.pandachannels.R;


public class SetThreeActivity extends AppCompatActivity {

    private ImageView pan_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_three);
        initView();
    }

    private void initView() {
        pan_back = (ImageView) findViewById(R.id.pan_back);
        pan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
