package com.example.administrator.myapplication01;


import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;

import java.util.concurrent.atomic.AtomicInteger;

import static android.view.Gravity.CENTER;


/**
 * Created by Administrator on 2018/7/23.
 */

public class AddCZ {

    TableRow add01;
    TableRow add02;
    TableRow add03;
    TableRow add04;
    TableRow add05;
    TableRow add06;
    TableRow add07;
    TableRow add08;
    TableRow add09;
    TableRow add10;
    TableRow add11;
    TableRow add12;
    TableRow add13;
    TableRow add14;
    TableRow add15;
    TableRow add16;
    TableRow add17;
    TableRow add18;
    TableRow add19;
    TableRow add20;
    TableRow add21;
    TableRow add22;

    static  int count = 1;

    static  String sr[] = new String[500];
    static  String sr_zd[] = new String[500];



    static Context context00 ;
    //assert context00  != null;


    static  int chongce = 0;

    //添加TextView的函数
    public static void AddTextView(String str,TableRow tb,Context context)
    {
        TableRow.LayoutParams stv = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.MATCH_PARENT);
        TextView tv = new TextView(context);
        tv.setTextColor(Color.rgb(0,0,0));
        tv.setBackgroundColor(Color.rgb(220,220,220));
        tv.setText(str);
        tv.setLayoutParams(stv);
        tv.setGravity(CENTER);

        tb.addView(tv);
    }

    public static void AddTextView_shuchu(String str,TableRow tb,Context context)
    {
        TableRow.LayoutParams stv = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.MATCH_PARENT);
        TextView tv = new TextView(context);
        tv.setTextColor(Color.rgb(0,0,0));
        //tv.setBackgroundColor(Color.rgb(220,220,220));
        tv.setText(str);
        tv.setLayoutParams(stv);
        tv.setGravity(CENTER);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);

        tb.addView(tv);
    }

    //添加EditText的函数
    ////添加测站点号函数
    public static void AddEditText_PointName(String str, TableRow tb, final EditText ed,Context context, final int n)
    {
        //count+=1;

        TableRow.LayoutParams sed = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        //ed = new EditText(context);
        //context00 = context;
        //ed.requestFocus();

        for (int i=0 ;i<500;i++)
        {
            sr[i] = new String();
        }

        ed.setLayoutParams(sed);
        SpannableString ss = new SpannableString(str);
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(16,true);
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ed.setHint(new SpannedString(ss));
        ed.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_NORMAL);
        ed.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);

        //InputMethodManager imm=getSystemService(Context.INPUT_METHOD_SERVICE);

        //ed.setId(generateViewId());
        //ed.addTextChangedListener(this);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //sr[count] = ed.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                sr[n] = ed.getText().toString();
                Log.i("String add()",n+" "+sr[n]);

            }

        });

        tb.addView(ed);

        // return generateViewId();
    }

    //添加EditText的函数
    public static void AddEditText(String str, TableRow tb, Context context, final int n)
    {
        //count+=1;

        TableRow.LayoutParams sed = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        final EditText ed = new EditText(context);
        //context00 = context;

         for (int i=0 ;i<500;i++)
        {
            sr[i] = new String();
        }



        ed.setLayoutParams(sed);
        SpannableString ss = new SpannableString(str);
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(16,true);
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ed.setHint(new SpannedString(ss));
        ed.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_VARIATION_NORMAL);
        ed.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);

        //InputMethodManager imm=getSystemService(Context.INPUT_METHOD_SERVICE);

        //ed.setId(generateViewId());
        //ed.addTextChangedListener(this);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //sr[count] = ed.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                sr[n] = ed.getText().toString();
                Log.i("String add()",n+" "+sr[n]);

            }

        });

        tb.addView(ed);

        // return generateViewId();
    }

    //后前前后的添加函数
    public static void Add03(int num,AddCZ cz,TableLayout added,Context context)
    {
        Log.i("Add() has been called",Integer.toString(num));
        //num++;

        //TableLayout added = findViewById(R.id.table);
        //要添加进去的表格
        TableLayout add0 = new TableLayout(context);
        //把要添加进去的表格先存到一个表格里，再整体添加

        //cz = new AddCZ();
        //之所以是 num-1 因为

        cz.add01 = new TableRow(context);
        cz.add02 = new TableRow(context);
        cz.add03 = new TableRow(context);
        cz.add04 = new TableRow(context);
        cz.add05 = new TableRow(context);
        cz.add06 = new TableRow(context);
        cz.add07 = new TableRow(context);
        cz.add08 = new TableRow(context);
        cz.add09 = new TableRow(context);
        cz.add10 = new TableRow(context);
        cz.add11 = new TableRow(context);
        cz.add12 = new TableRow(context);
        cz.add13 = new TableRow(context);
        cz.add14 = new TableRow(context);
        cz.add15 = new TableRow(context);
        cz.add16 = new TableRow(context);
        cz.add17 = new TableRow(context);
        cz.add18 = new TableRow(context);
        cz.add19 = new TableRow(context);
        cz.add20 = new TableRow(context);
        cz.add21 = new TableRow(context);
        cz.add22 = new TableRow(context);


        //if (z)

        //第一行，添加测站号
        cz.AddTextView("测站：" + num,cz.add01,context);


        //第二行,为空
        TextView tv02 = new TextView(context);
        cz.add02.addView(tv02);

        //第三行
        // 添加 前视点号
        cz.AddTextView("后视点点号：", cz.add03,context);

        //添加输入前视点点号
        final EditText ed_back = new EditText(context);
        cz.AddEditText_PointName("请输入后视点点号", cz.add03,ed_back,context,count);
        ed_back.requestFocus();
        count+=1;

        //第四行为空
        TextView tv04 = new TextView(context);
        cz.add04.addView(tv04);

        //第五行
        //添加 后视点号
        cz.AddTextView("前视点点号：", cz.add05,context);

        //添加输入后视点号
        final EditText ed_front = new EditText(context);
        cz.AddEditText_PointName("请输入前视点点号", cz.add05,ed_front ,context,count);

        count+=1;

        //第六行为空
        TextView tv06 = new TextView(context);
        cz.add06.addView(tv06);

        //第七行
        //添加 后视黑面上丝
        cz.AddTextView("后视黑面上丝：", cz.add07,context);

        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add07,context,count);
        count+=1;

        //第八行为空
        TextView tv08 = new TextView(context);
        cz.add08.addView(tv08);

        //第九行
        //添加黑面下丝
        cz.AddTextView("后视黑面下丝：", cz.add09,context);

        //添加 输入黑面下丝
        cz.AddEditText("下丝读数（单位:mm）", cz.add09,context,count);
        count+=1;

        //第十行 为空
        TextView tv10 = new TextView(context);
        cz.add10.addView(tv10);

        //第十一行
        //添加 后视黑面中丝
        cz.AddTextView("后视黑面中丝：", cz.add11,context);

        //添加 输入黑面中丝
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add11,context,count);
        count+=1;



        //第十二行为空
        TextView tv12 = new TextView(context);
        cz.add12.addView(tv12);

        //第十三行
        // 添加前视黑面上丝
        cz.AddTextView("前视黑面上丝：", cz.add13,context);
        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add13,context,count);
        count+=1;

        //第十四行
        TextView tv14 = new TextView(context);
        cz.add14.addView(tv14);

        //第十五行
        //添加前视黑面下丝
        cz.AddTextView("前视黑面下丝：", cz.add15,context);
        cz.AddEditText("下丝读数（单位:mm）", cz.add15,context,count);
        count+=1;

        //第十六行
        TextView tv16 = new TextView(context);
        cz.add16.addView(tv16);

        //十七行
        cz.AddTextView("前视黑面中丝：", cz.add17,context);
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add17,context,count);
        count+=1;

        //第十八行
        TextView tv18 = new TextView(context);
        cz.add18.addView(tv18);

        //第十九行
        cz.AddTextView("前视红面中丝：", cz.add19,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add19,context,count);
        count+=1;

        //第二十行
        TextView tv20 = new TextView(context);
        cz.add20.addView(tv20);

        //第二十一行
        cz.AddTextView("后视红面中丝：", cz.add21,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add21,context,count);
        count+=1;

        //第二十二行
        TextView tv22 = new TextView(context);
        cz.add22.addView(tv22);

        /*第十九行
        //assert SZjisuan.str != null;
        if (SZjisuan.str == null)
            SZjisuan.str = " ";
        cz.AddTextView(SZjisuan.str,cz.add19,context);
        Log.i("提示信息",SZjisuan.str);


        //第二十行
        TextView tv20 = new TextView(context);
        cz.add20.addView(tv20);*/

        //在要添加的TableLayout中添加TableRow
        add0.addView( cz.add01);
        add0.addView( cz.add02);
        add0.addView( cz.add03);
        add0.addView( cz.add04);
        add0.addView( cz.add05);
        add0.addView( cz.add06);
        add0.addView( cz.add07);
        add0.addView( cz.add08);
        add0.addView( cz.add09);
        add0.addView( cz.add10);
        add0.addView( cz.add11);
        add0.addView( cz.add12);
        add0.addView( cz.add13);
        add0.addView( cz.add14);
        add0.addView( cz.add15);
        add0.addView( cz.add16);
        add0.addView( cz.add17);
        add0.addView( cz.add18);
        add0.addView( cz.add19);
        add0.addView( cz.add20);
        add0.addView( cz.add21);
        add0.addView( cz.add22);

        added.addView(add0);
    }


    //添加转点
    public static void Add03_zd(int num,AddCZ cz,TableLayout added,Context context)
    {
        //应把num_zd的值传入num
        Log.i("Add_zd() called",Integer.toString(num));
        //num++;

        //TableLayout added = findViewById(R.id.table);
        //要添加进去的表格
        TableLayout add0 = new TableLayout(context);
        //把要添加进去的表格先存到一个表格里，再整体添加

        //cz = new AddCZ();
        //之所以是 num-1 因为

        cz.add01 = new TableRow(context);
        cz.add02 = new TableRow(context);
        cz.add03 = new TableRow(context);
        cz.add04 = new TableRow(context);
        cz.add05 = new TableRow(context);
        cz.add06 = new TableRow(context);
        cz.add07 = new TableRow(context);
        cz.add08 = new TableRow(context);
        cz.add09 = new TableRow(context);
        cz.add10 = new TableRow(context);
        cz.add11 = new TableRow(context);
        cz.add12 = new TableRow(context);
        cz.add13 = new TableRow(context);
        cz.add14 = new TableRow(context);
        cz.add15 = new TableRow(context);
        cz.add16 = new TableRow(context);
        cz.add17 = new TableRow(context);
        cz.add18 = new TableRow(context);
        cz.add19 = new TableRow(context);
        cz.add20 = new TableRow(context);
        cz.add21 = new TableRow(context);
        cz.add22 = new TableRow(context);


        //第一行，添加测站号
        cz.AddTextView("转点：" + num,cz.add01,context);


        //第二行,为空
        TextView tv02 = new TextView(context);
        cz.add02.addView(tv02);

        //第三行
        // 添加 前视点号
        cz.AddTextView("后视点点号：", cz.add03,context);

        //添加输入前视点点号
        EditText ed_back = new EditText(context);
        cz.AddEditText_PointName("请输入后视点点号", cz.add03,ed_back,context,count);
        ed_back.requestFocus();
        count+=1;

        //第四行为空
        TextView tv04 = new TextView(context);
        cz.add04.addView(tv04);

        //第五行
        //添加 后视点号
        cz.AddTextView("前视点点号：", cz.add05,context);

        //添加输入后视点号
        EditText ed_front = new EditText(context);
        cz.AddEditText_PointName("请输入前视点点号", cz.add05,ed_front,context,count);
        count+=1;

        //第六行为空
        TextView tv06 = new TextView(context);
        cz.add06.addView(tv06);

        //第七行
        //添加 后视黑面上丝
        cz.AddTextView("后视黑面上丝：", cz.add07,context);

        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add07,context,count);
        count+=1;

        //第八行为空
        TextView tv08 = new TextView(context);
        cz.add08.addView(tv08);

        //第九行
        //添加黑面下丝
        cz.AddTextView("后视黑面下丝：", cz.add09,context);

        //添加 输入黑面下丝
        cz.AddEditText("下丝读数（单位:mm）", cz.add09,context,count);
        count+=1;

        //第十行 为空
        TextView tv10 = new TextView(context);
        cz.add10.addView(tv10);

        //第十一行
        //添加 后视黑面中丝
        cz.AddTextView("后视黑面中丝：", cz.add11,context);

        //添加 输入黑面中丝
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add11,context,count);
        count+=1;

        //第十二行为空
        TextView tv12 = new TextView(context);
        cz.add12.addView(tv12);

        ///第十三行
        // 添加前视黑面上丝
        cz.AddTextView("前视黑面上丝：", cz.add13,context);
        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add13,context,count);
        count+=1;

        //第十四行
        TextView tv14 = new TextView(context);
        cz.add14.addView(tv14);

        //第十五行
        //添加前视黑面下丝
        cz.AddTextView("前视黑面下丝：", cz.add15,context);
        cz.AddEditText("下丝读数（单位:mm）", cz.add15,context,count);
        count+=1;

        //第十六行
        TextView tv16 = new TextView(context);
        cz.add16.addView(tv16);

        //十七行
        cz.AddTextView("前视黑面中丝：", cz.add17,context);
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add17,context,count);
        count+=1;

        //第十八行
        TextView tv18 = new TextView(context);
        cz.add18.addView(tv18);

        //第十九行
        cz.AddTextView("前视红面中丝：", cz.add19,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add19,context,count);
        count+=1;

        //第二十行
        TextView tv20 = new TextView(context);
        cz.add20.addView(tv20);

        //第二十一行
        cz.AddTextView("后视红面中丝：", cz.add21,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add21,context,count);
        count+=1;

        //第二十二行
        TextView tv22 = new TextView(context);
        cz.add22.addView(tv22);


        //在要添加的TableLayout中添加TableRow
        add0.addView( cz.add01);
        add0.addView( cz.add02);
        add0.addView( cz.add03);
        add0.addView( cz.add04);
        add0.addView( cz.add05);
        add0.addView( cz.add06);
        add0.addView( cz.add07);
        add0.addView( cz.add08);
        add0.addView( cz.add09);
        add0.addView( cz.add10);
        add0.addView( cz.add11);
        add0.addView( cz.add12);
        add0.addView( cz.add13);
        add0.addView( cz.add14);
        add0.addView( cz.add15);
        add0.addView( cz.add16);
        add0.addView( cz.add17);
        add0.addView( cz.add18);
        add0.addView( cz.add19);
        add0.addView( cz.add20);
        add0.addView( cz.add21);
        add0.addView( cz.add22);

        added.addView(add0);
    }

    //后后前期的添加函数
    public static void Add04(int num,AddCZ cz,TableLayout added,Context context)
    {
        Log.i("Add() has been called",Integer.toString(num));
        //num++;

        //TableLayout added = findViewById(R.id.table);
        //要添加进去的表格
        TableLayout add0 = new TableLayout(context);
        //把要添加进去的表格先存到一个表格里，再整体添加

        //cz = new AddCZ();
        //之所以是 num-1 因为

        cz.add01 = new TableRow(context);
        cz.add02 = new TableRow(context);
        cz.add03 = new TableRow(context);
        cz.add04 = new TableRow(context);
        cz.add05 = new TableRow(context);
        cz.add06 = new TableRow(context);
        cz.add07 = new TableRow(context);
        cz.add08 = new TableRow(context);
        cz.add09 = new TableRow(context);
        cz.add10 = new TableRow(context);
        cz.add11 = new TableRow(context);
        cz.add12 = new TableRow(context);
        cz.add13 = new TableRow(context);
        cz.add14 = new TableRow(context);
        cz.add15 = new TableRow(context);
        cz.add16 = new TableRow(context);
        cz.add17 = new TableRow(context);
        cz.add18 = new TableRow(context);
        cz.add19 = new TableRow(context);
        cz.add20 = new TableRow(context);
        cz.add21 = new TableRow(context);
        cz.add22 = new TableRow(context);


        //第一行，添加测站号
        cz.AddTextView("测站：" + num,cz.add01,context);


        //第二行,为空
        TextView tv02 = new TextView(context);
        cz.add02.addView(tv02);

        //第三行
        // 添加 前视点号
        cz.AddTextView("后视点点号：", cz.add03,context);

        //添加输入前视点点号
        EditText ed_back = new EditText(context);
        cz.AddEditText_PointName("请输入后视点点号", cz.add03,ed_back,context,count);
        ed_back.requestFocus();
        count+=1;

        //第四行为空
        TextView tv04 = new TextView(context);
        cz.add04.addView(tv04);

        //第五行
        //添加 后视点号
        cz.AddTextView("前视点点号：", cz.add05,context);

        //添加输入后视点号
        EditText ed_front = new EditText(context);
        cz.AddEditText_PointName("请输入前视点点号", cz.add05,ed_front,context,count);
        count+=1;

        //第六行为空
        TextView tv06 = new TextView(context);
        cz.add06.addView(tv06);

        //第七行
        //添加 后视黑面上丝
        cz.AddTextView("后视黑面上丝：", cz.add07,context);

        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add07,context,count);
        count+=1;

        //第八行为空
        TextView tv08 = new TextView(context);
        cz.add08.addView(tv08);

        //第九行
        //添加黑面下丝
        cz.AddTextView("后视黑面下丝：", cz.add09,context);

        //添加 输入黑面下丝
        cz.AddEditText("下丝读数（单位:mm）", cz.add09,context,count);
        count+=1;

        //第十行 为空
        TextView tv10 = new TextView(context);
        cz.add10.addView(tv10);

        //第十一行
        //添加 后视黑面中丝
        cz.AddTextView("后视黑面中丝：", cz.add11,context);

        //添加 输入黑面中丝
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add11,context,count);
        count+=1;



        //第十二行为空
        TextView tv12 = new TextView(context);
        cz.add12.addView(tv12);

        //第十三行
        cz.AddTextView("后视红面中丝：", cz.add13,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add13,context,count);
        count+=1;

        //第十四行
        TextView tv14 = new TextView(context);
        cz.add14.addView(tv14);

        //第十五行
        // 添加前视黑面上丝
        cz.AddTextView("前视黑面上丝：", cz.add15,context);
        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add15,context,count);
        count+=1;

        //第十六行
        TextView tv16 = new TextView(context);
        cz.add16.addView(tv16);

        //第十七行
        //添加前视黑面下丝
        cz.AddTextView("前视黑面下丝：", cz.add17,context);
        cz.AddEditText("下丝读数（单位:mm）", cz.add17,context,count);
        count+=1;

        //第十八行
        TextView tv18 = new TextView(context);
        cz.add18.addView(tv18);

        //十九行
        cz.AddTextView("前视黑面中丝：", cz.add19,context);
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add19,context,count);
        count+=1;

        //第二十行
        TextView tv20 = new TextView(context);
        cz.add20.addView(tv20);

        //第二十一行
        cz.AddTextView("前视红面中丝：", cz.add21,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add21,context,count);
        count+=1;

        //第二十二行
        TextView tv22 = new TextView(context);
        cz.add22.addView(tv22);



        //在要添加的TableLayout中添加TableRow
        add0.addView( cz.add01);
        add0.addView( cz.add02);
        add0.addView( cz.add03);
        add0.addView( cz.add04);
        add0.addView( cz.add05);
        add0.addView( cz.add06);
        add0.addView( cz.add07);
        add0.addView( cz.add08);
        add0.addView( cz.add09);
        add0.addView( cz.add10);
        add0.addView( cz.add11);
        add0.addView( cz.add12);
        add0.addView( cz.add13);
        add0.addView( cz.add14);
        add0.addView( cz.add15);
        add0.addView( cz.add16);
        add0.addView( cz.add17);
        add0.addView( cz.add18);
        add0.addView( cz.add19);
        add0.addView( cz.add20);
        add0.addView( cz.add21);
        add0.addView( cz.add22);

        added.addView(add0);
    }



    public static void Add04_zd(int num,AddCZ cz,TableLayout added,Context context)
    {
        //应把num_zd的值传入num
        Log.i("Add_zd() called",Integer.toString(num));
        //num++;

        //TableLayout added = findViewById(R.id.table);
        //要添加进去的表格
        TableLayout add0 = new TableLayout(context);
        //把要添加进去的表格先存到一个表格里，再整体添加

        //cz = new AddCZ();
        //之所以是 num-1 因为

        cz.add01 = new TableRow(context);
        cz.add02 = new TableRow(context);
        cz.add03 = new TableRow(context);
        cz.add04 = new TableRow(context);
        cz.add05 = new TableRow(context);
        cz.add06 = new TableRow(context);
        cz.add07 = new TableRow(context);
        cz.add08 = new TableRow(context);
        cz.add09 = new TableRow(context);
        cz.add10 = new TableRow(context);
        cz.add11 = new TableRow(context);
        cz.add12 = new TableRow(context);
        cz.add13 = new TableRow(context);
        cz.add14 = new TableRow(context);
        cz.add15 = new TableRow(context);
        cz.add16 = new TableRow(context);
        cz.add17 = new TableRow(context);
        cz.add18 = new TableRow(context);
        cz.add19 = new TableRow(context);
        cz.add20 = new TableRow(context);
        cz.add21 = new TableRow(context);
        cz.add22 = new TableRow(context);


        //第一行，添加测站号
        cz.AddTextView("转点：" + num,cz.add01,context);


        //第二行,为空
        TextView tv02 = new TextView(context);
        cz.add02.addView(tv02);

        //第三行
        // 添加 前视点号
        cz.AddTextView("后视点点号：", cz.add03,context);

        //添加输入前视点点号
        EditText ed_back = new EditText(context);
        cz.AddEditText_PointName("请输入后视点点号", cz.add03,ed_back,context,count);
        ed_back.requestFocus();
        count+=1;

        //第四行为空
        TextView tv04 = new TextView(context);
        cz.add04.addView(tv04);

        //第五行
        //添加 后视点号
        cz.AddTextView("前视点点号：", cz.add05,context);

        //添加输入后视点号
        EditText ed_front = new EditText(context);
        cz.AddEditText_PointName("请输入前视点点号", cz.add05,ed_front,context,count);
        count+=1;

        //第六行为空
        TextView tv06 = new TextView(context);
        cz.add06.addView(tv06);

        //第七行
        //添加 后视黑面上丝
        cz.AddTextView("后视黑面上丝：", cz.add07,context);

        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add07,context,count);
        count+=1;

        //第八行为空
        TextView tv08 = new TextView(context);
        cz.add08.addView(tv08);

        //第九行
        //添加黑面下丝
        cz.AddTextView("后视黑面下丝：", cz.add09,context);

        //添加 输入黑面下丝
        cz.AddEditText("下丝读数（单位:mm）", cz.add09,context,count);
        count+=1;

        //第十行 为空
        TextView tv10 = new TextView(context);
        cz.add10.addView(tv10);

        //第十一行
        //添加 后视黑面中丝
        cz.AddTextView("后视黑面中丝：", cz.add11,context);

        //添加 输入黑面中丝
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add11,context,count);
        count+=1;

        //第十二行为空
        TextView tv12 = new TextView(context);
        cz.add12.addView(tv12);

        //第十三行
        cz.AddTextView("后视红面中丝：", cz.add13,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add13,context,count);
        count+=1;

        //第十四行为空
        TextView tv14 = new TextView(context);
        cz.add14.addView(tv14);

        ///第十五行
        // 添加前视黑面上丝
        cz.AddTextView("前视黑面上丝：", cz.add15,context);
        //添加 输入黑面上丝
        cz.AddEditText("上丝读数（单位:mm）", cz.add15,context,count);
        count+=1;

        //第十六行为空
        TextView tv16 = new TextView(context);
        cz.add16.addView(tv16);

        //第十七行
        //添加前视黑面下丝
        cz.AddTextView("前视黑面下丝：", cz.add17,context);
        cz.AddEditText("下丝读数（单位:mm）", cz.add17,context,count);
        count+=1;

        //第十八行为空
        TextView tv18 = new TextView(context);
        cz.add18.addView(tv18);

        //十九行
        cz.AddTextView("前视黑面中丝：", cz.add19,context);
        cz.AddEditText("黑面中丝读数（单位:mm）", cz.add19,context,count);
        count+=1;

        //第二十行为空
        TextView tv20 = new TextView(context);
        cz.add20.addView(tv20);

        //第二十一行
        cz.AddTextView("前视红面中丝：", cz.add21,context);
        cz.AddEditText("红面中丝读数（单位:mm）", cz.add21,context,count);
        count+=1;

        //第二十二行
        TextView tv22 = new TextView(context);
        cz.add22.addView(tv22);


        //在要添加的TableLayout中添加TableRow
        add0.addView( cz.add01);
        add0.addView( cz.add02);
        add0.addView( cz.add03);
        add0.addView( cz.add04);
        add0.addView( cz.add05);
        add0.addView( cz.add06);
        add0.addView( cz.add07);
        add0.addView( cz.add08);
        add0.addView( cz.add09);
        add0.addView( cz.add10);
        add0.addView( cz.add11);
        add0.addView( cz.add12);
        add0.addView( cz.add13);
        add0.addView( cz.add14);
        add0.addView( cz.add15);
        add0.addView( cz.add16);
        add0.addView( cz.add17);
        add0.addView( cz.add18);
        add0.addView( cz.add19);
        add0.addView( cz.add20);
        add0.addView( cz.add21);
        add0.addView( cz.add22);

        added.addView(add0);
    }
}