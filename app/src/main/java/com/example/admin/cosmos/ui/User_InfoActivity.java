package com.example.admin.cosmos.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.admin.cosmos.R;
/*****
 * created by cjr
 * 1057809324@qq.com
 *****/
public class User_InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__info);
        RelativeLayout about=(RelativeLayout)findViewById(R.id.layout_about_app);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_InfoActivity.this,AboutUsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        RelativeLayout feedback=(RelativeLayout)findViewById(R.id.layout_feed_back);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_InfoActivity.this,FeedbackActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
