package com.example.administrator.myapplication01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
* btn_bffb 是后前前后模式
* btn_bbff 是后后前前模式
* btn_back01 是返回上一步
 */

public class Activitydemo02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitydemo02);

        //设置“后前前后”按钮的监听事件
        Button button_bffb=(Button) findViewById(R.id.button_bffb);
        assert  button_bffb!=null;
        button_bffb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Activitydemo03.class);
                startActivity(intent);
            }
        });

        //设置“后后前前”按钮的监听事件
        Button button_bbff = (Button) findViewById(R.id.button_bbff);
        assert  button_bbff != null;
        button_bbff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Activitydemo04.class);
                startActivity(intent);
            }
        });

        //设置“上一步”按钮的监听事件
        Button button_back01=(Button) findViewById(R.id.button_back01);
        assert  button_back01!=null;
        button_back01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();   //关闭页面
                //以下是跳转页面的代码
                //Intent intent=new Intent(getApplicationContext(),MainActivity01.class);
                //startActivity(intent);
            }
        });
    }
}
