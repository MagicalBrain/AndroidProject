package com.example.administrator.myapplication01;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/24.
 */

public class SZceduan implements Parcelable {
    int ceduanxuhao;//测段序号
    String houshi;
    String qianshi;//前后视点号
    double juli;//一测段距离
    double gaocha ;//实测高差
    int gaizheng;//改正数
    double gaizhenggaocha;//改正后高差
    double gaocheng;//前视点高程

    protected SZceduan(Parcel in) {
        // 在读取Parcel容器里的数据时，必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
        ceduanxuhao = in.readInt();
        houshi = in.readString();
        qianshi = in.readString();
        juli = in.readDouble();
        gaocha = in.readDouble();
        gaizheng = in.readInt();
        gaizhenggaocha = in.readDouble();
        gaocheng = in.readDouble();
    }

    public static final Creator<SZceduan> CREATOR = new Creator<SZceduan>() {
        // 再通过createFromParcel将Parcel对象映射成原对象
        @Override
        public SZceduan createFromParcel(Parcel in) {
            return new SZceduan(in);
        }

        // 供外部类反序列化本类数组使用
        @Override
        public SZceduan[] newArray(int size) {
            return new SZceduan[size];
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
        dest.writeInt(ceduanxuhao);
        dest.writeString(houshi);
        dest.writeString(qianshi);
        dest.writeDouble(juli);
        dest.writeDouble(gaocha);
        dest.writeInt(gaizheng);
        dest.writeDouble(gaizhenggaocha);
        dest.writeDouble(gaizheng);
    }

    public SZceduan() {
        //this.name = "未知";
        //this.age = 18;
    }

}