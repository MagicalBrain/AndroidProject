package com.example.administrator.myapplication01;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/7/24.
 */

//包含了要用到的所有水准计算函数
public class SZjisuan {
    static  int MAX = 50;
    static String str;
    //提示显示时间
    static int time = 15000;

    private static void controlToastTime(final Toast toast, int duration)
    {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        },3500);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        },duration);
    }



    public static int sslr0(double x)
    //定义保留整数四舍六入函数
    {
        int a,b,c;
        if(x>=0)
        {
            a=(int)(x*10);
            b=(int)(x);
            if (a%10>=6)
                c=b+1;
            else if (a%10<=4)
                c=b;
            else if (b%2==0)
                c=b;
            else
                c=b+1;
            return c;
        }
        //x为正数的运算

        else
        {
            x=-x;
            a=(int)(x*10);
            b=(int)(x);
            if(a%10>=6)
                c=b+1;
            else if (a%10<=4)
                c=b;
            else if (b%2==0)
                c=b;
            else
                c=b+1;
            return(-c);
        }
        //x为负数数的运算
    }

    public static double sslr(double x,int a)
    {
        int n,m1,m2 ;

        switch (a)
        {
            case 1:
                n = 10;
                break;
            case 2:
                n = 100;
                break;
            case 3:
                n = 1000;
                break;
            default:
                n = 10;
                break;
        }

        m1 = (int) (x*n*10) % 10;
        m2 = (int) (x*n) % 10;
        if (m1 == 5)
        {
            if (m2 % 2 == 0)
                x = x -  1/(n*10.0);
        }

        switch (a)
        {
            case 1:
                x = Double.parseDouble(String.format("%.1f",x));
                break;
            case 2:
                x =  Double.parseDouble(String.format("%.2f",x));
                break;
            case 3:
                x = Double.parseDouble(String.format("%.3f",x));
                break;
            default:
                break;
        }

        return x;
    }

    public static int shijupanduan(double qianshiju, double houshiju, Context context)
    //判断视距是否超限
    {
        Log.i("前视距",Double.toString(qianshiju) + " (m)");
        Log.i("后视距",Double.toString(houshiju) + " (m)");
        //Toast toast = new Toast(this);
        if(qianshiju>100)
        {
            Toast toast = Toast.makeText(context,"前视距超限了！",Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            //toast.show();
            return 1;
        }
        if(houshiju>100)
        {
            Toast toast = Toast.makeText(context,"后视距超限了！",Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            return 1;
        }
        return 0;
    }

    public static int shijuchapanduan(double qianshiju,double houshiju,double shijucha,Context context)
    //判断视距差是否超限
    {
        Log.i("视距差",Double.toString(Math.abs(shijucha)) + " (m)");
        if(Math.abs(shijucha)<=5)
            return 0;
        else if(qianshiju>houshiju)
        {
            Toast toast = Toast.makeText(context,"视距差超限了！请注意提示信息！",Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            //Toast.makeText(context,"视距差超限了！请注意提示信息！",Toast.LENGTH_SHORT).show();
            //TextView et_double_BBshang =(EditText) findViewById(R.id.double_BBshang) ;
            //printf("前视距为：%.3lfm，后视距为%.3lf,前后视距差超限。建议保持测站不动，减小%.3lfm前视距",qianshiju,houshiju,fabs(shijucha/2));
            //转成字符串再输出
            str = "提示：\n" + "前视距为："+Double.toString(qianshiju)+",后视距为: "+Double.toString(houshiju)+",前后视距差超限。建议保持测站不动，减小"+Double.toString(Math.abs(shijucha/2))+" 前视距";
            Log.i("提示信息",str);
            return 1;
        }
        else
        {
            Toast toast = Toast.makeText(context,"视距差超限了！请注意提示信息！",Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            // printf("前视距为：%.3lf，后视距为%.3lfm,前后视距差超限。建议保持测站不动，增大%.3lfm前视距",qianshiju,houshiju,fabs(shijucha/2));
            str = "提示：\n" + "前视距为："+Double.toString(qianshiju)+",后视距为: "+Double.toString(houshiju)+",前后视距差超限。建议保持测站不动，增大"+Double.toString(Math.abs(shijucha/2))+ " 前视距";
            //Log.i("提示信息",str);
            return 1;
        }
    }

    //前后视距累积差提示和判断函数
    public static int qianhoushijuleijichapanduan(double shijuleijicha,Context context)
    {

        if (Math.abs(shijuleijicha)<=8)
            return 0;
        else if(Math.abs(shijuleijicha)<=10)
        {
            if(shijuleijicha>0)
            {
                str = "前后视距差累积值为:" + Double.toString(shijuleijicha) + " m，建议下一测站使前视距大于后视距\n";
                //printf("前后视距差累积值为%.3lfm，建议下一测站使前视距大于后视距\n",shijuleijicha);
                Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
                controlToastTime(toast,time);
                //Toast.makeText(context,str,Toast.LENGTH_LONG).show();
            }
            else
            {
                str = "前后视距差累积值为:" + Double.toString(shijuleijicha) + " m，建议下一测站使前视距小于后视距\n";
                //printf("前后视距差累积值为%.3lf，建议下一测站使前视距小于后视距\n",shijuleijicha);
                Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
                controlToastTime(toast,time);
                //Toast.makeText(context,str,Toast.LENGTH_LONG).show();
            }
            Log.i("前后视距累积差",str);
            return 0;
        }
        //前后视距累积差不超限但绝对值大于8m

        else if(shijuleijicha>0)
        {
            str = "前后视距差累积值为:" + Double.toString(shijuleijicha) + " m，提示：视距差累积超限。建议保持测站不动，增大前视距\n";
            //printf("前后视距差累积值为%.3lfm，提示：视距差累积超限。建议保持测站不动，增大前视距\n",shijuleijicha);
            Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            //Toast.makeText(context,str,Toast.LENGTH_LONG).show();
        }
        else
        {
            str = "前后视距差累积值为:" + Double.toString(shijuleijicha) + " m，提示：视距差累积超限。建议保持测站不动，减小前视距\n";
            //printf("前后视距差累积值为%.3lf，提示：视距差累积超限。建议保持测站不动，减小前视距\n",shijuleijicha);
            Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            //Toast.makeText(context,str,Toast.LENGTH_LONG).show();
        }
        Log.i("前后视距累积差",str);
        return 1;
    }

    //后视点红黑面读数差是否超限
    public  static int houdushuchapanduan(int hongheidushucha,Context context)
    {
        Log.i("后视点红黑面读数差",Integer.toString(hongheidushucha));
        if(Math.abs(hongheidushucha)>3)
        {
            str = "提示：后视点红黑面读数差（" + Integer.toString(hongheidushucha) + " mm）超限，建议重新对后视点进行观测\n";
            //printf("后视点红黑面读数差为%dmm，提示：后视点红黑面读数差超限，建议重新对后视点进行观测\n",hongheidushucha);
            Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            Log.i("后视点红黑面读数差",str);
            return 1;
        }
        else
        {
            str = "提示：后视点红黑面读数差（" + Integer.toString(hongheidushucha) + " mm）超限，建议重新对后视点进行观测\n";
            Log.i("后视点红黑面读数差",str);
            return 0;
        }

    }

    //前视点红黑面读数差是否超限
    public  static int qiandushuchapanduan(int qianheidushucha,Context context)
    {
        Log.i("后视点红黑面读数差",Integer.toString(qianheidushucha));
        if (Math.abs(qianheidushucha)>3)
        {
            str = "提示：前视点红黑面读数差（" + Integer.toString(qianheidushucha) + " mm）超限，建议重新对前视点进行观测\n";
            //printf("前视点红黑面读数差为%dmm，提示：前视点红黑面读数差超限，建议重新对前视点进行观测\n",hongheidushucha);
            Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
            controlToastTime(toast,time);

            return 1;
        }
        else
        {
            str = "提示：前视点红黑面读数差（" + Integer.toString(qianheidushucha) + " mm）超限，建议重新对前视点进行观测\n";
            Log.i("前视点红黑面读数差为:",str);
            return 0;
        }

    }

    //红黑面高差之差是否超限
    public static int gaochacha(int gaochacha,Context context)
    {
        if(Math.abs(gaochacha)>5)
        {
            str = "红黑面所测高差之差为:" + Integer.toString(gaochacha) + " mm，提示：重测该测站\n";
            //printf("红黑面所测高差之差为%dmm，提示：重测该测站\n",gaochacha);
            Toast toast = Toast.makeText(context,str,Toast.LENGTH_LONG);
            controlToastTime(toast,time);
            Log.i("红黑面所测高差之差",str);
            return 1;
        }
        else
        {
            str = "红黑面所测高差之差为:" + Integer.toString(gaochacha) + " mm，提示：重测该测站\n";
            Log.i("红黑面所测高差之差",str);
            return 0;
        }

    }

    //闭合差超限判断函数
    public static int bihechapanduan(double f,double s,int n)//闭合差超限判断
    {
        Log.i("闭合差判断","总高差：" + Double.toString(f) + "   " + "\n路线总长：" + Double.toString(s) + "\n总测站数：" + Integer.toString(n));
        int g;
        if (n/s*1000>=16)
        {
            if(Math.abs(f)>40*Math.sqrt(s/1000.0))
            {
                Log.i("bihechapanduan","超限了！");
                g=1;
            }
            else
                g=0;
        }
        else
        {
            if(Math.abs(f)>20*Math.sqrt(n))
            {
                Log.i("bihechapanduan","超限了！");
                g=1;
            }
            else
                g=0;
        }
        Log.i("判断闭合差","闭合差：" + Double.toString(Math.abs(f)));
        return g;
    }
}