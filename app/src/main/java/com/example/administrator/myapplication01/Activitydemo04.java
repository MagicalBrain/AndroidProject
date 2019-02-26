package com.example.administrator.myapplication01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import android.view.inputmethod.InputMethodManager;

//“后后前前”模式的页面

/*
* back_name 后视点点号
* front_name 前视点点号
*
* double_BBshang 后视黑面上丝
* double_BBxia 后视黑面下丝
* double_BBzhong 后视黑面中丝
*
* double_FBshang 前视黑面上丝
* double_FBxia 前视黑面下丝
* double_FBzhong 前视黑面中丝
*
* double_FHzhong 前视红面中丝
*
* double_BHzhong 后视红面中丝
* */

public class Activitydemo04 extends AppCompatActivity {
    //页面编号
    public static int activity_NUM;

    //测站数
    public static int num = 1;
    public static int num_tmp;

    //转点数
    public static int num_zd = 0;
    //SZjisuan SZjs = new SZjisuan();

    //添加对象的数组
    public static AddCZ[] cz = new AddCZ[SZjisuan.MAX];

    //添加的测站的数组
    public static SZcezhan[] SZcz00 = new SZcezhan[SZjisuan.MAX];

    //要传递的测站数据的动态数组
    static  ArrayList<SZcezhan> SZcz = new ArrayList<SZcezhan>();
    static  ArrayList<SZceduan> SZcd = new ArrayList<SZceduan>();

    //转点数组
    public static SZcezhan[] SZcz_zd = new SZcezhan[SZjisuan.MAX];
    public  static SZceduan[] SZcd00 = new SZceduan[SZjisuan.MAX];

    AddCZ cz00 = new AddCZ();

    int t1=4687,t2=4787;//定义基辅值
    int p,m,n,k,j=0,l,a=2;
    int i=0;
    double qidian,zhongdian;//定义起点和终点高程
    int flag = 0;

    //隐藏输入法
    public static void hidenInputMethod(View view,Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    //测站限差判断函数
    public static int  xianchapanduan(SZcezhan SZcz, Context context)
    {
        //SZcz = new SZcezhan();
        int n = 0;
        if (SZjisuan.shijupanduan(SZcz.qianshiju,SZcz.houshiju,context) != 0)
            n++;
        if (SZjisuan.shijuchapanduan(SZcz.qianshiju,SZcz.houshiju,SZcz.shijucha,context) != 0)
            n++;
        // if (SZjisuan.str.length()<1)
        //SZjisuan.str = " ";

        if (SZjisuan.qianhoushijuleijichapanduan(SZcz.shijuleijicha,context)  != 0)
            n++;
        if (SZjisuan.houdushuchapanduan(SZcz.houdushucha,context)  != 0)
            n++;
        if (SZjisuan.qiandushuchapanduan(SZcz.qiandushucha,context)  != 0)
            n++;
        if (SZjisuan.gaochacha(SZcz.gaochacha,context)  != 0)
            n++;
        Log.i("num:",Integer.toString(n));
        return n;
    }

    //测站重测函数
    public void SZchongce(int num, AddCZ cz00)
    {
        //测站重测
        TableLayout added = findViewById(R.id.table);
        AddCZ.Add04(num, cz00, added, Activitydemo04.this);
        //num =1;
        flag = 1;
    }

    public void SZchongce_zd(int num_zd, AddCZ cz00)
    {
        //转点重测
        TableLayout added = findViewById(R.id.table);
        AddCZ.Add04_zd(num_zd, cz00, added, Activitydemo04.this);
    }

    public void duquJT(SZcezhan SZcz00,SZceduan SZcd00,int zhuandian) {
        //读取静态输入
        //AddCZ cz00 = new AddCZ();

        EditText st_back_name = (EditText) findViewById(R.id.back_name);
        EditText st_front_name = (EditText) findViewById(R.id.front_name);

        String back_name = st_back_name.getText().toString();
        String front_name = st_front_name.getText().toString();

        SZcd00.qianshi = front_name;
        SZcd00.houshi = back_name;
        SZcd00.ceduanxuhao = num;

        //存储测站信息
        SZcz00.front_name = front_name;
        SZcz00.back_name = back_name;

        //SZcd[num-1] = SZcd00;

        EditText et_double_BBshang = (EditText) findViewById(R.id.double_BBshang);
        EditText et_double_BBxia = (EditText) findViewById(R.id.double_BBxia);
        EditText et_double_FBshang = (EditText) findViewById(R.id.double_FBshang);
        EditText et_double_FBxia = (EditText) findViewById(R.id.double_FBxia);

        EditText et_double_BBzhong = (EditText) findViewById(R.id.double_BBzhong);
        EditText et_double_BHzhong = (EditText) findViewById(R.id.double_BHzhong);
        EditText et_double_FBzhong = (EditText) findViewById(R.id.double_FBzhong);
        EditText et_double_FHzhong = (EditText) findViewById(R.id.double_FHzhong);

        String str_BBshang = et_double_BBshang.getText().toString();
        Log.i("demo04-str_BBshang:",str_BBshang);
        String str_BBxia = et_double_BBxia.getText().toString();
        Log.i("demo04-str_str_BBxia:",str_BBxia);
        String str_FBshang = et_double_FBshang.getText().toString();
        Log.i("demo04-str_FBshang:",str_FBshang);
        String str_FBxia = et_double_FBxia.getText().toString();
        Log.i("demo04-str_FBxia:",str_FBxia);

        String str_BBzhong = et_double_BBzhong.getText().toString();
        Log.i("demo04-str_BBzhong:",str_BBzhong);
        String str_BHzhong = et_double_BHzhong.getText().toString();
        Log.i("demo04-str_BHzhong:",str_BHzhong);

        String str_FBzhong = et_double_FBzhong.getText().toString();
        Log.i("demo04-str_FBzhong:",str_FBzhong);
        String str_FHzhong = et_double_FHzhong.getText().toString();
        Log.i("demo04-str_FHzhong:",str_FHzhong);

        if (back_name.length() < 1 || front_name.length() < 1 || str_BBshang.length() < 1 || str_BBxia.length() < 1 || str_FBshang.length() < 1 || str_FBxia.length() < 1
                || str_BBzhong.length() < 1 || str_BHzhong.length() < 1 || str_FBzhong.length() < 1 || str_FHzhong.length() < 1) {
            Toast.makeText(Activitydemo04.this, "请输入完整数据！", Toast.LENGTH_LONG).show();
            Log.i("Activitydemo04--addcz", back_name);
        } else {
            SZcz00.BB_shang = str_BBshang;
            SZcz00.BB_xia = str_BBxia;

            SZcz00.FB_shang = str_FBshang;
            SZcz00.FB_xia = str_FBxia;

            SZcz00.BB_zhong = str_BBzhong;
            SZcz00.BH_zhong = str_BHzhong;

            SZcz00.FB_zhong = str_FBzhong;
            SZcz00.FH_zhong = str_FHzhong;
            SZcz00.flag = num;

            int int_BBshang = Integer.parseInt(str_BBshang);
            int int_BBxia = Integer.parseInt(str_BBxia);
            int int_FBshang = Integer.parseInt(str_FBshang);
            int int_FBxia = Integer.parseInt(str_FBxia);

            int int_BBzhong = Integer.parseInt(str_BBzhong);
            int int_BHzhong = Integer.parseInt(str_BHzhong);

            int int_FBzhong = Integer.parseInt(str_FBzhong);
            int int_FHzhong = Integer.parseInt(str_FHzhong);

            SZcz00.qianshiju = (int_FBshang - int_FBxia) / 10.0;
            SZcz00.houshiju = (int_BBshang - int_BBxia) / 10.0;
            SZcz00.shijucha = SZcz00.houshiju - SZcz00.qianshiju;
            SZcz00.shijuleijicha = SZcz00.shijucha;

                if (Math.abs(int_BHzhong - int_BBzhong - t1) < Math.abs(int_BHzhong - int_BBzhong - t2))
                    p = 1;
                else
                    p = 0;//判断第一站后视点的基辅值是4687还是4787

                if (p == 1) {
                    SZcz00.houdushucha = int_BBzhong - int_BHzhong + t1;
                    SZcz00.qiandushucha = int_FBzhong - int_FHzhong + t2;
                } else {
                    SZcz00.houdushucha = int_BBzhong - int_BHzhong + t2;
                    SZcz00.qiandushucha = int_FBzhong - int_FHzhong + t1;
                }

                SZcz00.heigaocha = int_BBzhong - int_FBzhong;
                SZcz00.honggaocha = int_BHzhong - int_FHzhong;

                if (Math.abs(SZcz00.honggaocha - SZcz00.heigaocha - 100) < Math.abs(SZcz00.honggaocha - SZcz00.heigaocha + 100))
                    SZcz00.gaochacha = SZcz00.honggaocha - SZcz00.heigaocha - 100;
                    //计算红黑面高差之差
                else
                    SZcz00.gaochacha = SZcz00.honggaocha - SZcz00.heigaocha + 100;

                if (Math.abs(int_BBzhong - int_FBzhong - (int_BHzhong - int_FHzhong - 100)) <= 5)
                    SZcz00.gaochazhongshu = (double) SZjisuan.sslr0((int_BBzhong - int_FBzhong + int_BHzhong - int_FHzhong - 100) / 2) / 1000.0;
                else
                    SZcz00.gaochazhongshu = (double) SZjisuan.sslr0((int_BBzhong - int_FBzhong + int_BHzhong - int_FHzhong + 100) / 2) / 1000.0;

                if (xianchapanduan(SZcz00, Activitydemo04.this) == 0) {
                    Toast.makeText(Activitydemo04.this, "数据合格，可进行下一站测量", Toast.LENGTH_LONG).show();

                    //添加测站(转点)
                    if (zhuandian == 1) {
                        num_zd += 1;
                        TableLayout added = findViewById(R.id.table);
                        AddCZ.Add04_zd(num_zd, cz00, added, Activitydemo04.this);

                    }
                    else {
                        TableLayout added = findViewById(R.id.table);
                        AddCZ.Add04(num + 1 - num_zd, cz00, added, Activitydemo04.this);
                    }
                    SZcz.add(SZcz00);
                    SZcd.add(SZcd00);
                    Log.i("demo04 String add()", 1 + " " + cz00.sr[1]);
                    cz[num - 1] = cz00;

                    num += 1;
                    Log.i("demo04", "测站：" + Integer.toString(num - 1) + "高差中数：" + Double.toString(SZcz.get(0).gaochazhongshu) + "距离：" + Double.toString(SZcz.get(0).houshiju + SZcz.get(0).qianshiju));
                    Log.i("SZcz", "数组元素个数：" + Integer.toString(SZcz.size()));
                    flag = 0;
                }
                else {
                    //String strts = "提示：\n"+"前视距为："+Double.toString(SZcz00.qianshiju)+",后视距为: "+Double.toString(SZcz00.houshiju)+",前后视距差超限。建议保持测站不动，减小"+Double.toString(Math.abs(SZcz00.shijucha/2))+" 前视距";
                    Toast.makeText(Activitydemo04.this, SZjisuan.str, Toast.LENGTH_LONG).show();

                    //重测
                    if (SZcz00.zhuandian == 1)
                        SZchongce_zd(num_zd, cz00);
                    else {
                        SZchongce(num - num_zd, cz00);
                        num = 1;
                    }
                }
            }

        }


    public void  duquDT(AddCZ cz00,SZceduan SZcd00, SZcezhan SZcz00,int zhuandian)
    {
        int num_cz = num;
        //读取动态输入
        //读取后视点名
        String back_name = new String();
        back_name = cz00.sr[1 + i];
        //assert  back_name != null;
        Log.i("demo04 String add()", 1 + " " + cz[num - 1].sr[1 + i]);
        Log.i("demo04 String add()", 1 + " " + back_name);

        //读取前视点名
        String front_name = new String();
        front_name = cz00.sr[2 + i];
        //assert  front_name != null;
        Log.i("demo03 String add()", 2 + " " + cz[num - 1].sr[2 + i]);
        Log.i("demo03 String add()", 2 + " " + front_name);

        //储存点名
        SZcd00.qianshi = front_name;
        SZcd00.houshi = back_name;

        SZcz00.front_name = front_name;
        SZcz00.back_name = back_name;
        //SZcd[num-1] = SZcd00;

        //读取后黑上丝
        String str_BBshang = new String();
        str_BBshang = cz00.sr[3 + i];
        //assert  str_BBshang != null;
        Log.i("demo04 String add()", 3 + " " + cz00.sr[3 + i]);
        Log.i("demo04 String add()", 3 + " " + str_BBshang);

        //读取后黑下丝
        String str_BBxia = new String();
        str_BBxia = cz00.sr[4 + i];
        //assert  str_BBxia != null;
        Log.i("demo04 String add()", 4 + " " + cz00.sr[4 + i]);

        //读取后黑中丝
        String str_BBzhong = new String();
        str_BBzhong = cz00.sr[5 + i];

        SZcz00.BB_zhong = str_BBzhong;
        //assert  str_BBzhong != null;
        Log.i("demo04 String add()", 5 + " " + cz00.sr[5 + i]);

        //读取后红中丝
        String str_BHzhong = new String();
        str_BHzhong = cz00.sr[6 + i];

        SZcz00.BH_zhong = str_BHzhong;
        //assert  str_BHzhong != null;
        Log.i("demo04 String add()", 6 + " " + cz00.sr[6 + i]);

        //读取前黑上丝
        String str_FBshang = new String();
        str_FBshang = cz00.sr[7 + i];

        SZcz00.FB_shang = str_FBshang;
        //assert  str_FBshang != null;
        Log.i("demo04 String add()", 7 + " " + cz00.sr[7 + i]);

        //读取前黑下丝
        String str_FBxia = new String();
        str_FBxia = cz00.sr[8 + i];

        SZcz00.FB_xia  =str_FBxia;
        //assert  str_FBxia != null;
        Log.i("demo04 String add()", 8 + " " + cz00.sr[8 + i]);

        //读取前黑中丝
        String str_FBzhong = new String();
        str_FBzhong = cz00.sr[9 + i];

        SZcz00.FB_zhong = str_FBzhong;
        //assert  str_FBzhong != null;
        Log.i("demo04 String add()", 9 + " " + cz00.sr[9 + i]);

        //读取前红中丝
        String str_FHzhong = new String();
        str_FHzhong = cz00.sr[10 + i];

        SZcz00.FH_zhong = str_FHzhong;
        //assert  str_FHzhong != null;
        Log.i("demo04 String add()", 10 + " " + cz00.sr[10 + i]);

        int n = 0;
        for (int a = 1; a <= 10; a++) {
            if (cz00.sr[a + i].length() < 1)
                n++;
        }
        if (n > 0)
            Toast.makeText(Activitydemo04.this, "请输入完整数据！", Toast.LENGTH_LONG).show();
        else {
            int int_BBshang = Integer.parseInt(str_BBshang);
            int int_BBxia = Integer.parseInt(str_BBxia);
            int int_FBshang = Integer.parseInt(str_FBshang);
            int int_FBxia = Integer.parseInt(str_FBxia);

            int int_BBzhong = Integer.parseInt(str_BBzhong);
            int int_BHzhong = Integer.parseInt(str_BHzhong);

            int int_FBzhong = Integer.parseInt(str_FBzhong);
            int int_FHzhong = Integer.parseInt(str_FHzhong);

            SZcz00.qianshiju = (int_FBshang - int_FBxia) / 10.0;
            SZcz00.houshiju = (int_BBshang - int_BBxia) / 10.0;
            SZcz00.shijucha = SZcz00.houshiju - SZcz00.qianshiju;
            SZcz00.shijuleijicha = SZcz00.shijucha;

            if (Math.abs(int_BHzhong - int_BBzhong - t1) < Math.abs(int_BHzhong - int_BBzhong - t2))
                p = 1;
            else
                p = 0;//判断第一站后视点的基辅值是4687还是4787

            if (p == 1) {
                SZcz00.houdushucha = int_BBzhong - int_BHzhong + t1;
                SZcz00.qiandushucha = int_FBzhong - int_FHzhong + t2;
            } else {
                SZcz00.houdushucha = int_BBzhong - int_BHzhong + t2;
                SZcz00.qiandushucha = int_FBzhong - int_FHzhong + t1;
            }

            //计算前后高差
            SZcz00.heigaocha = int_BBzhong - int_FBzhong;
            SZcz00.honggaocha = int_BHzhong - int_FHzhong;

            if (Math.abs(SZcz00.honggaocha - SZcz00.heigaocha - 100) < Math.abs(SZcz00.honggaocha - SZcz00.heigaocha + 100))
                SZcz00.gaochacha = SZcz00.honggaocha - SZcz00.heigaocha - 100;
                //计算红黑面高差之差
            else
                SZcz00.gaochacha = SZcz00.honggaocha - SZcz00.heigaocha + 100;

            if (Math.abs(SZcz00.honggaocha - SZcz00.heigaocha - 100) < Math.abs(SZcz00.honggaocha - SZcz00.heigaocha + 100))
                SZcz00.gaochacha = SZcz00.honggaocha - SZcz00.heigaocha - 100;
            else
                SZcz00.gaochacha = SZcz00.honggaocha - SZcz00.heigaocha + 100;

            if (Math.abs(int_BBzhong - int_FBzhong - (int_BHzhong - int_FHzhong - 100)) <= 5)
                SZcz00.gaochazhongshu = (double) SZjisuan.sslr0((int_BBzhong - int_FBzhong + int_BHzhong - int_FHzhong - 100) / 2) / 1000.0;
            else
                SZcz00.gaochazhongshu = (double) SZjisuan.sslr0((int_BBzhong - int_FBzhong + int_BHzhong - int_FHzhong + 100) / 2) / 1000.0;

            num_tmp = num;
            if (xianchapanduan(SZcz00, Activitydemo04.this) == 0)
            {
                Toast.makeText(Activitydemo04.this, "数据合格，可进行下一站测量", Toast.LENGTH_LONG).show();

                TableLayout added = findViewById(R.id.table);

                i += 10;

                //添加测站（转点）
                if (zhuandian == 1)
                {
                    num_zd +=1;
                    flag = num_zd;
                    Log.i("demo04","flag: " + flag);
                    AddCZ.Add04_zd(num_zd,cz00,added,Activitydemo04.this);
                }
                else
                    AddCZ.Add04(num + 1 - num_zd, cz00, added, Activitydemo04.this);

                SZcz.add(SZcz00);
                SZcd.add(SZcd00);
                cz[num - 1] = cz00;
                num += 1;

                Log.i("demo04", "测站：" + Integer.toString(num - 1) + "高差中数：" + Double.toString(SZcz.get(SZcz.size() - 1).gaochazhongshu) + "距离：" + Double.toString(SZcz.get(SZcz.size() - 1).houshiju + SZcz.get(SZcz.size() - 1).qianshiju));
                Log.i("SZcz", "数组个数" + Integer.toString(SZcz.size()));
            }
            else {

                Toast.makeText(Activitydemo04.this, SZjisuan.str, Toast.LENGTH_LONG).show();

                //重测
                if (SZcz00.zhuandian == 1) {
                    SZchongce_zd(num_zd, cz00);
                    if (num_cz != 1)
                        i += 10;
                }else
                {
                    if (num_cz != 1) {
                        num = num_tmp;
                        SZchongce(num - num_zd, cz00);
                        i += 10;
                    }
                    else {
                        SZchongce(num - num_zd, cz00);
                        num = 1;
                    }

                }
                Log.i("demo04 duquDT",Integer.toString(num));

            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitydemo04);

        activity_NUM  = 4;
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);



        //数组初始化
        for (int i = 0; i < SZjisuan.MAX; i++) {
            SZcz00[i] = new SZcezhan();
            SZcd00[i] = new SZceduan();
            cz[i] = new AddCZ();
        }

        //在页面第一行添加测站号
        String str = "测站：" + num;
        TextView et_string01 = (TextView) findViewById(R.id.et_string01);
        et_string01.setText(str);

        //“添加转点”按钮
        Button button_zd = (Button) findViewById(R.id.button_add_zd);
        assert button_zd != null;
        button_zd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Activity04 addzd called", "The num_zd is:" + num_zd);
                //Toast.makeText(Activitydemo04.this, "技术君努力开发中", Toast.LENGTH_LONG).show();

                Log.i("Activitydemo04", "添加转点   The num is:" + num);
                //Log.i("Activitydemo03", "添加转点   The num_zd is:" + num_zd);
                //public static int  xianchapanduan(SZcezhan SZcz, Context context);

                //第一个测站，读取静态数据
                if (num == 1) {
                    if (flag == 0) {
                        SZcz00[num].zhuandian = 1;
                        duquJT(SZcz00[num - 1], SZcd00[num - 1],1);
                    }
                    else {
                        //读取动态输入
                        SZcz00[num].zhuandian = 1;
                        duquDT(cz00,SZcd00[num - 1],SZcz00[num - 1],1);
                    }

                } else
                //num大于1的情况
                {
                    //int i=0;
                    Log.i("demo04--addcz", "The num is:" + num);

                    //读取动态输入
                    SZcz00[num].zhuandian = 1;
                    duquDT(cz00,SZcd00[num - 1],SZcz00[num - 1],1);
                }
            }

        });

        //“继续测量”按钮的触发事件
        Button button_addcz = (Button) findViewById(R.id.button_addcz);
        assert button_addcz != null;
        button_addcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置一个重测监听器，如果是重测，则为1；


                Log.i("Activitydemo04", "继续测量   The num is:" + num);
                Log.i("Activitydemo04", "继续测量   The flag is:" + flag);
                //public static int  xianchapanduan(SZcezhan SZcz, Context context);

                //第一个测站，读取静态数据
                if (num == 1) {
                    if (flag == 0)
                    {
                        //读取静态输入
                        duquJT(SZcz00[num - 1],SZcd00[num - 1],0);
                    }
                    else {
                        //读取动态输入
                        duquDT(cz00,SZcd00[num - 1],SZcz00[num - 1],0);
                    }
                } else
                //num大于1的情况
                {
                    //int i=0;
                    Log.i("demo04--addcz", "The num is:" + num);

                    //读取动态输入
                    duquDT(cz00,SZcd00[num - 1],SZcz00[num - 1],0);
                }

            }
            //第一个 if 对应的 else 结束
        });


        //“重测”按钮的触发事件
        Button button_chongce = (Button) findViewById(R.id.button_chongce);
        assert button_chongce != null;
        button_chongce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AddCZ.chongce == 1)
                {
                    SZcz.clear();
                    SZcd.clear();
                    num = 1;
                    num_zd = 0;
                    Log.i("demo04 重测", Integer.toString(num));

                    //重测
                    SZchongce(num,cz00);

                    //TableLayout added = findViewById(R.id.table);
                    //AddCZ.Add(num, cz00, added, Activitydemo04.this);
                    Log.i("demo04 重测",Integer.toString(num));
                    //num = num_tmp;
                    i += 10;
                }
                else
                    Toast.makeText(Activitydemo04.this,"不可用！",Toast.LENGTH_SHORT).show();
            }
        });



        //“结束测量”按钮的触发事件
        Button button_end = (Button) findViewById(R.id.button_end);
        assert button_end != null;
        button_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("demo03 end() called", Integer.toString(num));
                if (num > 1) {
                    //最后一站的计算过程
                    //读取动态输入
                    Log.i("最后一站","num is:" + num);
                    String back_name = cz[num - 1].sr[1 + i];
                    assert back_name != null;
                    Log.i("demo04 String add()", 1 + " " + cz[num - 1].sr[1 + i]);
                    Log.i("demo04 String add()", 1 + " " + back_name);

                    String front_name = cz[num - 1].sr[2 + i];
                    assert front_name != null;
                    Log.i("demo04 String add()", 2 + " " + cz[num - 1].sr[2 + i]);
                    Log.i("demo04 String add()", 2 + " " + front_name);

                    SZcd00[num - 1].qianshi = front_name;
                    SZcd00[num - 1].houshi = back_name;

                    //SZcd[num-1] = SZcd00;

                    //读取后黑上丝
                    String str_BBshang = cz[num - 1].sr[3 + i];
                    assert str_BBshang != null;
                    Log.i("demo04 String add()", 3 + " " + cz[num - 1].sr[3 + i]);
                    Log.i("demo04 String add()", 3 + " " + str_BBshang);

                    //读取后黑下丝
                    String str_BBxia = cz[num - 1].sr[4 + i];
                    assert str_BBxia != null;
                    Log.i("demo04 String add()", 4 + " " + cz[num - 1].sr[4 + i]);

                    //读取后黑中丝
                    String str_BBzhong = cz[num - 1].sr[5 + i];
                    assert str_BBzhong != null;
                    Log.i("demo04 String add()", 5 + " " + cz[num - 1].sr[5 + i]);

                    //后红中丝
                    String str_BHzhong = cz[num - 1].sr[10 + i];
                    assert str_BHzhong != null;
                    Log.i("demo04 String add()", 6 + " " + cz[num - 1].sr[6 + i]);

                    //读取前黑上丝
                    String str_FBshang = cz[num - 1].sr[7 + i];
                    assert str_FBshang != null;
                    Log.i("demo04 String add()", 7 + " " + cz[num - 1].sr[7 + i]);

                    //读取前黑下丝
                    String str_FBxia = cz[num - 1].sr[8 + i];
                    assert str_FBxia != null;
                    Log.i("demo04 String add()", 8 + " " + cz[num - 1].sr[8 + i]);

                    //前黑中丝
                    String str_FBzhong = cz[num - 1].sr[9 + i];
                    assert str_FBzhong != null;
                    Log.i("demo04 String add()", 9 + " " + cz[num - 1].sr[9 + i]);

                    //前红中丝
                    String str_FHzhong = cz[num - 1].sr[10 + i];
                    assert str_FHzhong != null;
                    Log.i("demo04 String add()", 10 + " " + cz[num - 1].sr[10 + i]);

                    if (back_name.length() < 1 || front_name.length() < 1 || str_BBshang.length() < 1 || str_BBxia.length() < 1 || str_FBshang.length() < 1 || str_FBxia.length() < 1
                            || str_BBzhong.length() < 1 || str_BHzhong.length() < 1 || str_FBzhong.length() < 1 || str_FHzhong.length() < 1) {
                        Toast.makeText(Activitydemo04.this, "请输入完整数据！", Toast.LENGTH_LONG).show();
                    } else {
                        int int_BBshang = Integer.parseInt(str_BBshang);
                        int int_BBxia = Integer.parseInt(str_BBxia);
                        int int_FBshang = Integer.parseInt(str_FBshang);
                        int int_FBxia = Integer.parseInt(str_FBxia);

                        int int_BBzhong = Integer.parseInt(str_BBzhong);
                        int int_BHzhong = Integer.parseInt(str_BHzhong);

                        int int_FBzhong = Integer.parseInt(str_FBzhong);
                        int int_FHzhong = Integer.parseInt(str_FHzhong);

                        SZcz00[num - 1].qianshiju = (int_FBshang - int_FBxia) / 10.0;
                        SZcz00[num - 1].houshiju = (int_BBshang - int_BBxia) / 10.0;
                        SZcz00[num - 1].shijucha = SZcz00[num - 1].houshiju - SZcz00[num - 1].qianshiju;
                        SZcz00[num - 1].shijuleijicha = SZcz00[num - 1].shijucha;

                        if (Math.abs(int_BHzhong - int_BBzhong - t1) < Math.abs(int_BHzhong - int_BBzhong - t2))
                            p = 1;
                        else
                            p = 0;//判断第一站后视点的基辅值是4687还是4787

                        if (p == 1) {
                            SZcz00[num - 1].houdushucha = int_BBzhong - int_BHzhong + t1;
                            SZcz00[num - 1].qiandushucha = int_FBzhong - int_FHzhong + t2;
                        } else {
                            SZcz00[num - 1].houdushucha = int_BBzhong - int_BHzhong + t2;
                            SZcz00[num - 1].qiandushucha = int_FBzhong - int_FHzhong + t1;
                        }

                        //计算前后高差
                        SZcz00[num - 1].heigaocha = int_BBzhong - int_FBzhong;
                        SZcz00[num - 1].honggaocha = int_BHzhong - int_FHzhong;

                        if (Math.abs(SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha - 100) < Math.abs(SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha + 100))
                            SZcz00[num - 1].gaochacha = SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha - 100;
                            //计算红黑面高差之差
                        else
                            SZcz00[num - 1].gaochacha = SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha + 100;

                        if (Math.abs(SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha - 100) < Math.abs(SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha + 100))
                            SZcz00[num - 1].gaochacha = SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha - 100;
                        else
                            SZcz00[num - 1].gaochacha = SZcz00[num - 1].honggaocha - SZcz00[num - 1].heigaocha + 100;

                        if (Math.abs(int_BBzhong - int_FBzhong - (int_BHzhong - int_FHzhong - 100)) <= 5)
                            SZcz00[num - 1].gaochazhongshu = (double) SZjisuan.sslr0((int_BBzhong - int_FBzhong + int_BHzhong - int_FHzhong - 100) / 2) / 1000.0;
                        else
                            SZcz00[num - 1].gaochazhongshu = (double) SZjisuan.sslr0((int_BBzhong - int_FBzhong + int_BHzhong - int_FHzhong + 100) / 2) / 1000.0;


                        //判断是否满足各项限差要求
                        if (xianchapanduan(SZcz00[num - 1], Activitydemo04.this) == 0) {
                            Toast.makeText(Activitydemo04.this, "数据合格，可结束测量", Toast.LENGTH_LONG).show();

                            SZcz00[num - 1].back_name = back_name;
                            SZcz00[num - 1].front_name = front_name;

                            SZcz00[num - 1].BB_shang = str_BBshang;
                            SZcz00[num - 1].BB_xia = str_BBxia;

                            SZcz00[num - 1].FB_shang = str_FBshang;
                            SZcz00[num - 1].FB_xia = str_FBxia;

                            SZcz00[num - 1].BB_zhong = str_BBzhong;
                            SZcz00[num - 1].BH_zhong = str_BHzhong;

                            SZcz00[num - 1].FB_zhong = str_FBzhong;
                            SZcz00[num - 1].FH_zhong = str_FHzhong;
                            SZcz00[num - 1].flag = num;

                            Log.i("demo04 结束测量—重测后NUM:",Integer.toString(num));
                            Log.i("demo04 结束测量—重测后 flag:",Integer.toString(flag));

                           // Log.i("demo04 结束测量—重测后",Integer.toString(num));

                            SZcz.add(SZcz00[num - 1]);
                            SZcd.add(SZcd00[num - 1]);
                            cz[num - 1] = cz00;

                            if (flag == 1)
                                num += 1;

                            Log.i("demo04", "测站：" + Integer.toString(num) + "高差中数：" + Double.toString(SZcz00[num - 1].gaochazhongshu) + "距离：" + Double.toString(SZcz00[num - 1].houshiju + SZcz00[num - 1].qianshiju));

                            Intent intent = new Intent(getApplicationContext(), Activitydemo05.class);
                            intent.putExtra("num", num);
                            intent.putExtra("activity_NUM", activity_NUM);

                            intent.putParcelableArrayListExtra("SZczlist", SZcz);
                            intent.putParcelableArrayListExtra("SZcdlist", SZcd);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Activitydemo04.this, SZjisuan.str, Toast.LENGTH_LONG).show();

                            //重测
                            SZchongce(num,cz00);
                            //TableLayout added = findViewById(R.id.table);
                            //AddCZ.Add(num, cz00, added, Activitydemo04.this);
                            Log.i("demo04 结束测量—重测",Integer.toString(num));
                            //num = num_tmp;
                            i += 10;
                            //num =1;
                            //flag = 1;
                        }


                    }
                } else {
                    Toast.makeText(Activitydemo04.this, "请完成测量", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //“上一步”按钮触发事件
        Button button_back = (Button) findViewById(R.id.button_back);
        assert button_back != null;
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("demo04 back() called", Integer.toString(num));
                SZcz.clear();
                SZcd.clear();
                num = 1;
                num_zd = 0;
                //i = 0;
                //zero = 1;
                cz00.count = 1;
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
        num = 1;
        num_zd = 0;
        //i += 10;
        //zero = 1;
        cz00.count = 1;
        finish();
    }
}