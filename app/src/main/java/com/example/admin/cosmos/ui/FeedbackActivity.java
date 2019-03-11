package com.example.admin.cosmos.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.cosmos.R;
import com.example.admin.cosmos.fragment.UserFragment;
/*****
 * created by cjr
 * 1057809324@qq.com
 *****/
public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ImageView return_user_button=(ImageView) findViewById(R.id.back_button);
        return_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FeedbackActivity.this,UserFragment.class);
                startActivity(intent);
                finish();
            }
        });
        TextView return_user_Text=(TextView) findViewById(R.id.back_text);
        return_user_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FeedbackActivity.this,UserFragment.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
