package com.example.administrator.myapplication01;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/24.
 */

public class SZcezhan implements Parcelable{
        double qianshiju;//定义前视距
        double houshiju;//定义后视距
        double shijucha;//视距差
        double shijuleijicha;//视距累积差
        int qiandushucha;//定义了前视黑红面读数差
        int houdushucha;//定义了后视黑红面读数差
        int heigaocha;//黑面高差
        int honggaocha;//红面高差
        int gaochacha;//定义了红黑面高差之差
        int zhuandian;//测段前视点的转点标识
        double gaochazhongshu;//高差中数

        //后视点名
        String back_name;
        //前视点名
        String front_name;

        //后黑上丝
        String BB_shang;
        //后黑下丝
        String BB_xia;
        //后黑中丝
        String BB_zhong;

        //前黑上丝
        String FB_shang;
        //前黑下丝
        String FB_xia;
        //前黑中丝
        String FB_zhong;

        //后红中丝
        String BH_zhong;
        //前红中丝
        String FH_zhong;

        //测站序号
        int flag;

        protected SZcezhan(Parcel in) {
                // 在读取Parcel容器里的数据时，必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
                qianshiju = in.readDouble();
                houshiju = in.readDouble();
                shijucha = in.readDouble();
                shijuleijicha = in.readDouble();
                qiandushucha = in.readInt();
                houdushucha = in.readInt();
                heigaocha = in.readInt();
                honggaocha = in.readInt();
                gaochacha = in.readInt();
                zhuandian = in.readInt();
                gaochazhongshu = in.readDouble();

            back_name = in.readString();
            front_name= in.readString();

            BB_shang= in.readString();
            BB_xia= in.readString();
            BB_zhong= in.readString();

            FB_shang= in.readString();
            FB_xia= in.readString();
            FB_zhong= in.readString();

           BH_zhong= in.readString();
           FH_zhong= in.readString();

            flag= in.readInt();
        }

        public static final Creator<SZcezhan> CREATOR = new Creator<SZcezhan>() {
                // 再通过createFromParcel将Parcel对象映射成原对象
                @Override
                public SZcezhan createFromParcel(Parcel in) {
                        return new SZcezhan(in);
                }

                // 供外部类反序列化本类数组使用
                @Override
                public SZcezhan[] newArray(int size) {
                        return new SZcezhan[size];
                }

        };

        // 内容接口描述，默认返回0即可
        @Override
        public int describeContents() {
                return 0;
        }

        // 按照声明顺序打包数据到Parcel对象中，既将数据打包到Parcel容器中
        @Override
        public void writeToParcel(Parcel dest, int flags) {
                dest.writeDouble(qianshiju);
                dest.writeDouble(houshiju);
                dest.writeDouble(shijucha);
                dest.writeDouble(shijuleijicha);
                dest.writeInt(qiandushucha);
                dest.writeInt(houdushucha);
                dest.writeInt(heigaocha);
                dest.writeInt(honggaocha);
                dest.writeInt(gaochacha);
                dest.writeInt(zhuandian);
                dest.writeDouble(gaochazhongshu);

            dest.writeString(back_name);
            dest.writeString(front_name);
            dest.writeString(BB_shang);
            dest.writeString(BB_xia);
            dest.writeString(BB_zhong);
            dest.writeString(FB_shang);
            dest.writeString(FB_xia);
            dest.writeString(FB_zhong);
            dest.writeString(BH_zhong);
            dest.writeString(FH_zhong);
            dest.writeInt(flag);

        }

        public SZcezhan() {
                //this.name = "未知";
                //this.age = 18;
        }

}
