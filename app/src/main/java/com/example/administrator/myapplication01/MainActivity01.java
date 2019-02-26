package com.example.administrator.myapplication01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
* btn01 是自定义
* btn02 是四等水准测量模式
*/

public class MainActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);

        //EditText et_password= (EditText) findViewById(R.id.et_password);
        //String password=et_password.getText().toString();
        //what?

        Button btn01=(Button) findViewById(R.id.btn01);
        assert btn01 != null;
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity01.this,"技术君努力开发中",Toast.LENGTH_LONG).show();
                Log.i("MainActivity","The button(自定义) has been clicked.");
            }
        });

        //设置页面跳转
        Button btn02=(Button) findViewById(R.id.btn02);
        assert btn02 != null;
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Activitydemo02.class);
                startActivity(intent);
                Log.i("MainActivity","The button(水准) has been clicked.");
            }
        });

        Button btn03=(Button) findViewById(R.id.jioacheng);
        assert btn03 != null;
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.zybuluo.com/Arbalest-Laevatain/note/1306203");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                //Log.i("MainActivity","The button(水准) has been clicked.");
            }
        });
    }
}