package com.example.administrator.myapplication01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.Gravity.CENTER;
//import static com.example.administrator.myapplication01.Activitydemo03.SZcd;

public class Activitydemo05 extends AppCompatActivity {

    //public static SZcezhan[] SZcz = new SZcezhan[SZjisuan.MAX];
    ArrayList<SZcezhan> SZcz = new ArrayList<SZcezhan>();
    ArrayList<SZceduan> SZcd = new ArrayList<SZceduan>();
    public static SZcezhan[] SZcz_zd = new SZcezhan[SZjisuan.MAX];
    //添加对象的数组
    public static AddCZ[] cz = new AddCZ[SZjisuan.MAX];

    AddCZ cz00 = new AddCZ();

    SZceduan SZcd00 =new SZceduan();

    //定义总测段长度
    public static double sum = 0.0;
    //初始化闭合差
    public static double f = 0.0;

    //改正数为0的测段数量
    static int n = 0;
    static int flag = 0;

    //控制改正数输出
    static int flag_GZ = 0;
    //控制测站数据输出
    static int flag_cezhan = 0;

    public static void hideKeyboard(Activity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        // 隐藏软键盘
        imm.hideSoftInputFromWindow(context.getWindow().getDecorView().getWindowToken(), 0);
    }

    //动态添加view
    public static  void Add_demo(SZcezhan SZcz00, AddCZ cz, TableLayout added, Context context, int Activity_NUM)
    {
        //要添加进去的表格
        TableLayout add0 = new TableLayout(context);

        //cz = new AddCZ();

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


        //读取前视点名
        String front_name = new String();
        String back_name = new String();

        //输出点名
        front_name = SZcz00.front_name;
        back_name = SZcz00.back_name;


        Log.i("demo05 String add()", 2 + " " + SZcz00.front_name);
        Log.i("demo05 String add()", 2 + " " + back_name);


        //读取后黑上丝
        String str_BBshang = new String();
        str_BBshang = SZcz00.BB_shang;



        //Log.i("demo03 String add()", 3 + " " + cz00.sr[3 + i]);
        Log.i("demo03 String add()", 3 + " " + str_BBshang);

        //读取后黑下丝
        String str_BBxia = new String();
        str_BBxia = SZcz00.BB_xia;


        Log.i("demo03 String add()", 4 + " " + str_BBxia);


        //读取前黑上丝
        String str_FBshang = new String();
        str_FBshang = SZcz00.FB_shang;


        Log.i("demo03 String add()", 6 + " " + str_FBshang);

        //读取前黑下丝
        String str_FBxia = new String();
        str_FBxia = SZcz00.FB_xia;

        Log.i("demo03 String add()", 7 + " " + str_FBxia);

        //读取后黑中丝
        String str_BBzhong = new String();
        str_BBzhong = SZcz00.BB_zhong;

        Log.i("demo03 String add()", 5 + " " + str_BBzhong );

        //读取后红中丝
        String str_BHzhong = new String();
        str_BHzhong = SZcz00.BH_zhong;

        Log.i("demo03 String add()", 10 + " " + str_BHzhong);


        //读取前黑中丝
        String str_FBzhong = new String();
        str_FBzhong = SZcz00.FB_zhong;

        Log.i("demo03 String add()", 8 + " " + str_FBzhong);

        //读取前红中丝
        String str_FHzhong = new String();
        str_FHzhong = SZcz00.FH_zhong;


        Log.i("demo03 String add()", 9 + " " + str_FHzhong);

    if (Activity_NUM == 3)
    {
        //第一行，添加测站号
        if (SZcz00.zhuandian == 0)
            cz.AddTextView("测站：" + SZcz00.flag,cz.add01,context);
        else
            cz.AddTextView("转点号：" + SZcz00.flag,cz.add01,context);
        Log.i("demo05","测站号（转点）" + SZcz00.flag);

        //第二行,为空
        TextView tv02 = new TextView(context);
        cz.add02.addView(tv02);

        //第三行
        // 添加 前视点号
        cz.AddTextView("后视点点号：" + back_name, cz.add03,context);
        cz.AddTextView("前视点点号：" + front_name, cz.add03,context);

        //第四行为空
        TextView tv04 = new TextView(context);
        cz.add04.addView(tv04);

        //第五行
        //添加 后黑上丝
        cz.AddTextView("后黑上丝：" + str_BBshang, cz.add05,context);

        cz.AddTextView("后黑下丝：" + str_BBxia, cz.add05,context);


        //第六行为空
        TextView tv06 = new TextView(context);
        cz.add06.addView(tv06);

        cz.AddTextView("后黑中丝：" + str_BBzhong, cz.add07,context);




        //第八行为空
        TextView tv08 = new TextView(context);
        cz.add08.addView(tv08);

        cz.AddTextView("前黑上丝：" + str_FBshang, cz.add09,context);
        cz.AddTextView("前黑下丝：" + str_FBxia, cz.add09,context);

        //第十行 为空
        TextView tv10 = new TextView(context);
        cz.add10.addView(tv10);

        cz.AddTextView("前黑中丝：" + str_FBzhong, cz.add11,context);


        //第十二行为空
        TextView tv12 = new TextView(context);
        cz.add12.addView(tv12);

        cz.AddTextView("前红中丝：" + str_FHzhong, cz.add13,context);
        cz.AddTextView("后红中丝：" + str_BHzhong, cz.add13,context);

        //第十四行为空
        TextView tv14 = new TextView(context);
        cz.add14.addView(tv14);
    }
    else
    {
        //第一行，添加测站号
        cz.AddTextView("测站：" + SZcz00.flag,cz.add01,context);

        //第二行,为空
        TextView tv02 = new TextView(context);
        cz.add02.addView(tv02);

        //第三行
        // 添加 前视点号
        cz.AddTextView("后视点点号：" + back_name, cz.add03,context);
        cz.AddTextView("前视点点号：" + front_name, cz.add03,context);

        //第四行为空
        TextView tv04 = new TextView(context);
        cz.add04.addView(tv04);

        //第五行
        //添加 后黑上丝
        cz.AddTextView("后黑上丝：" + str_BBshang, cz.add05,context);
        cz.AddTextView("    ", cz.add05,context);
        cz.AddTextView("后黑下丝：" + str_BBxia, cz.add05,context);

        //第六行为空
        TextView tv06 = new TextView(context);
        cz.add06.addView(tv06);

        cz.AddTextView("后黑中丝：" + str_BBzhong, cz.add07,context);
        cz.AddTextView("后红中丝：" + str_BHzhong, cz.add07,context);


        //第八行为空
        TextView tv08 = new TextView(context);
        cz.add08.addView(tv08);

        cz.AddTextView("前黑上丝：" + str_FBshang, cz.add09,context);
        cz.AddTextView("    ", cz.add09,context);
        cz.AddTextView("前黑下丝：" + str_FBxia, cz.add09,context);


        //第十行 为空
        TextView tv10 = new TextView(context);
        cz.add10.addView(tv10);

        cz.AddTextView("前黑中丝：" + str_FBzhong, cz.add11,context);
        cz.AddTextView("    ", cz.add11,context);
        cz.AddTextView("前红中丝：" + str_FHzhong, cz.add11,context);

        //第十二行为空
        TextView tv12 = new TextView(context);
        cz.add12.addView(tv12);
    }

    add0.addView(cz.add01);
    add0.addView(cz.add02);
    add0.addView(cz.add03);
    add0.addView(cz.add04);
    add0.addView(cz.add05);
    add0.addView(cz.add06);
    add0.addView(cz.add07);
    add0.addView(cz.add08);
    add0.addView(cz.add09);
    add0.addView(cz.add10);
    add0.addView(cz.add11);
    add0.addView(cz.add12);
    add0.addView(cz.add13);
    add0.addView(cz.add14);

    added.addView(add0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitydemo05);

       final EditText start_hength = findViewById(R.id.start_hength);
        start_hength.requestFocus();

        /*
        * intent.putExtra("SZcz", (Serializable) SZcz);
          intent.putExtra("SZcd", (Serializable) SZcd);
         */

        final CheckBox box01;
        box01 = (CheckBox) findViewById(R.id.box1);
        box01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                box01.isChecked();
                if (b)
                {
                    flag_GZ = 1;
                }
                else
                    flag_GZ = 0;
            }
        });

        final CheckBox box02;
        box02 = (CheckBox) findViewById(R.id.box2);
        box02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    flag_cezhan = 1;
                }
                else
                    flag_cezhan = 0;
            }
        });

        //“计算结果”按钮
        Button button_end=(Button) findViewById(R.id.button_end);
        assert  button_end !=null;
        button_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sum = 0;
                f = 0;n = 0;

                //读取前面页面中的测站数据
                Intent intent = getIntent();
                final int num = (int) getIntent().getSerializableExtra("num");
                final int activity_num = (int) getIntent().getSerializableExtra("activity_NUM");
                SZcdShort[] SZshort = new SZcdShort[num];
                //SZcezhan[] SZcz = (SZcezhan) getIntent().getSerializableExtra("SZcz");

                for (int i=0; i < num; i++)
                {
                    SZshort[i] = new SZcdShort();
                }

                //SZ
                SZcz =  intent.getParcelableArrayListExtra("SZczlist");
                SZcd =  intent.getParcelableArrayListExtra("SZcdlist");

                Log.i("Activity05 end() called","计算结果按钮被点击了"  + "num is:" + Integer.toString(num));

                //Log.i("demo03 String add()", 2 + " " + SZcz.get(0).front_name);
                //Log.i("demo03 String add()", 2 + " " + SZcz.get(1).front_name);
                //读取输入

                assert start_hength != null;
                String st_hength = start_hength.getText().toString();
                double st_h = Double.parseDouble(st_hength);

                EditText end_hength = findViewById(R.id.end_hength);
                assert end_hength != null;
                String e_hength = end_hength.getText().toString();
                double e_h = Double.parseDouble(e_hength);

                //计算闭合差
                f = st_h - e_h;
                Log.i("起始-终止", Double.toString(f)+" (m)");



                for (int i=0;i < SZcz.size();i++)
                {
                    //Activitydemo03.SZcz[i].hei
                    Log.i("Activity05 end() called",Integer.toString(i)+" 高差中数："+Double.toString(SZcz.get(i).gaochazhongshu));

                    //计算测段高差
                    SZcd.get(i).gaocha = SZcz.get(i).gaochazhongshu;
                    Log.i("Activity05 end() called",Integer.toString(i)+" 高差："+Double.toString(SZcd.get(i).gaocha));

                    Log.i("Activity05 end() called",Integer.toString(i)+" 后读数差："+Double.toString(SZcz.get(i).houdushucha));
                    Log.i("Activity05 end() called",Integer.toString(i)+" 前读数差："+Double.toString(SZcz.get(i).qiandushucha));

                    //计算测段距离
                    SZcd.get(i).juli = SZjisuan.sslr((SZcz.get(i).houshiju + SZcz.get(i).qianshiju),2);

                    Log.i("Activity05 end() called",Integer.toString(i)+" 距离（测段长）："+Double.toString(SZcd.get(i).juli));

                    //计算路线总长
                    sum += SZcd.get(i).juli;
                    Log.i("Activity05 end() called",Integer.toString(i)+" 路线总长："+Double.toString(sum));

                    //总高差
                    f += SZcd.get(i).gaocha;
                    Log.i("Activity05 end() called",Integer.toString(i)+" 总高差："+Double.toString(f));

                }

                f = SZjisuan.sslr0(f*1000.0);

                if (SZjisuan.bihechapanduan(f,sum,num) != 1)
                {
                    Toast.makeText(Activitydemo05.this,"闭合差合格",Toast.LENGTH_LONG).show();
                    Log.i("Activity05 end() called","闭合差为："+Double.toString(f));
                    for (int i=0;i < SZcd.size();i++)
                    {
                        SZcd.get(i).gaizheng = -SZjisuan.sslr0(SZcd.get(i).juli / sum*f);
                        Log.i("改正数",Double.toString(SZcd.get(i).juli / sum*f));
                        //计算高差改正数
                        Log.i("Activity05 end() called",Integer.toString(i)+" "+Double.toString(SZcd.get(i).gaizheng));



                        //改正数的特殊情况
                        if (SZcd.get(i).gaizheng == 0)
                            n++;
                    }

                    if (n == SZcd.size())
                    {
                        for (int i=0;i<SZcd.size();i++)
                        {
                            SZshort[i].ceduanchangdu = SZcd.get(i).juli;
                            SZshort[i].ceduanxuhao = i;
                        }

                        //根据测段距离排序
                        for (int i=0; i< SZcd.size()-1;i++)
                        {
                            for (int j=0;j < SZcd.size()-i-1;j++)
                            {
                                SZcdShort tmp = new SZcdShort();
                                if (SZshort[j].ceduanchangdu > SZshort[j+1].ceduanchangdu)
                                {
                                    tmp = SZshort[j];
                                    SZshort[j] = SZshort[j+1];
                                    SZshort[j+1] = tmp;
                                }
                            }
                        }

                        for (int i=0; i< SZcd.size();i++)
                        {
                            Log.i("改正数-排序"," " + Integer.toString(i) + "\n" + Double.toString(SZshort[i].ceduanchangdu) + "\n" + Integer.toString(SZshort[i].ceduanxuhao));
                        }

                        //设置改正数
                        for (int i=SZcd.size()-1; i>= SZcd.size()-f;i--)
                        {
                            if (f>0)
                                SZcd.get(SZshort[i].ceduanxuhao).gaizheng = -1;
                            else
                                SZcd.get(SZshort[i].ceduanxuhao).gaizheng = 1;
                        }

                    }

                    if (flag == 1) {
                        TableLayout added = findViewById(R.id.table);
                        added.removeAllViews();
                        //SZcz.clear();
                        //SZcd.clear();
                    }
                        for (int i = 0; i < SZcd.size(); i++) {

                            //计算改正高差
                            SZcd.get(i).gaizhenggaocha = SZcd.get(i).gaocha + (double) SZcd.get(i).gaizheng / 1000.0;
                            Log.i("Activity05 end() called", "改正高差：" + Integer.toString(i) + " " + Double.toString(SZcd.get(i).gaizhenggaocha));

                            //计算高程
                            if (i == 0)
                                SZcd.get(i).gaocheng = st_h + SZcd.get(i).gaizhenggaocha;
                            else
                                SZcd.get(i).gaocheng = SZcd.get(i - 1).gaizhenggaocha + SZcd.get(i).gaizhenggaocha;
                            Log.i("Activity05 end() called", Integer.toString(i) + " " + Double.toString(SZcd.get(i).gaocheng));

                            Log.i("demo05","是否转点" + SZcz.get(i).zhuandian);

                            //输出的时候收起输入法，以防挡住结果
                            hideKeyboard(Activitydemo05.this);

                            //输出数据
                            //添加测站
                            if (SZcz.get(i).zhuandian == 0) {
                                TableLayout added = findViewById(R.id.table);

                                TableRow added01 = new TableRow(Activitydemo05.this);
                                TableRow added02 = new TableRow(Activitydemo05.this);

                                AddCZ.AddTextView("测段序号：", added01, Activitydemo05.this);

                                AddCZ.AddTextView_shuchu(Integer.toString(i + 1), added01, Activitydemo05.this);

                                Log.i("测段序号：", " " + Integer.toString(i + 1));


                                AddCZ.AddTextView("后视点号：", added01, Activitydemo05.this);

                                AddCZ.AddTextView_shuchu(SZcd.get(i).houshi, added01, Activitydemo05.this);

                                Log.i("后视点号：", " " + SZcd.get(i).houshi);

                                AddCZ.AddTextView("前视点号：", added01, Activitydemo05.this);

                                TextView tv03 = new TextView(Activitydemo05.this);
                                tv03.setText(SZcd.get(i).qianshi);
                                added01.addView(tv03);
                                Log.i("前视点号：", " " + SZcd.get(i).qianshi);

                                AddCZ.AddTextView("测段长度：", added01, Activitydemo05.this);

                                TextView tv04 = new TextView(Activitydemo05.this);
                                tv04.setText(Double.toString(SZcd.get(i).juli));
                                added01.addView(tv04);
                                Log.i("测段长度：", " " + Double.toString(SZjisuan.sslr(SZcd.get(i).juli, 1)));

                                AddCZ.AddTextView("实测高差：", added01, Activitydemo05.this);

                                TextView tv05 = new TextView(Activitydemo05.this);
                                tv05.setText(Double.toString(SZcd.get(i).gaocha));
                                added01.addView(tv05);
                                Log.i("实测高差：", " " + Double.toString(SZcd.get(i).gaocha));

                                Log.i("demo05", "改正数控制" + flag_GZ);
                                if (box01.isChecked()) {
                                    AddCZ.AddTextView("改正数：", added01, Activitydemo05.this);

                                    TextView tv06 = new TextView(Activitydemo05.this);
                                    tv06.setText(Double.toString(SZcd.get(i).gaizheng));
                                    //Log.i("demo05","改正数控制 改正数：" +SZcd.get(i).gaizheng);
                                    added01.addView(tv06);
                                    Log.i("改正数：", " " + Double.toString(SZcd.get(i).gaizheng));
                                }

                                AddCZ.AddTextView("改正后高差：", added01, Activitydemo05.this);

                                TextView tv07 = new TextView(Activitydemo05.this);
                                tv07.setText(Double.toString( SZjisuan.sslr(SZcd.get(i).gaizhenggaocha,3)));
                                added01.addView(tv07);
                                Log.i("改正后高差：", " " + Double.toString(SZcd.get(i).gaizhenggaocha));

                                TextView tv00 = new TextView(Activitydemo05.this);
                                tv00.setText("\n");
                                added02.addView(tv00);

                                added.addView(added01);
                                added.addView(added02);

                            }

                            Log.i("demo 05", "页面标号：" + activity_num);
                            Log.i("demo 05", "控制测站数据输出：" + flag_cezhan);

                        }

                        if (box02.isChecked())
                        {
                            Log.i("demo05 Box02","SZcz.Size() = " + SZcz.size());
                            TableLayout added = findViewById(R.id.table);
                            for (int i = 0; i < SZcz.size(); i++)
                            {
                                Add_demo(SZcz.get(i),cz00,added,Activitydemo05.this,activity_num);
                            }
                        }

                    flag = 1;
                    }
                else
                {
                    Toast.makeText(Activitydemo05.this,"闭合差超限\n当前闭合差为" + Double.toString(f),Toast.LENGTH_LONG).show();
                    Log.i("Activity05 end() called","闭合差为："+Double.toString(f));
                    AddCZ.chongce = 1;
                }

            }
        });

        //“上一步”按钮
        Button button_back=(Button) findViewById(R.id.button_back);
        assert  button_back!=null;
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SZcz.clear();
                SZcd.clear();
                sum = 0.0;
                f = 0.0;
                flag = 0;
                n = 0;
                finish();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        SZcz.clear();
        SZcd.clear();
        sum = 0.0;
        f = 0.0;
        flag = 0;
        n = 0;
        //cz00.count = 1;
        finish();
    }
}