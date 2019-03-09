# AndroidProject

## 简要描述

这是一个基于安卓的四等水准计算实现。
在四等水准测量里有重测功能、添加转点功能，详细的可以查看使用[教程链接](https://www.zybuluo.com/Arbalest-Laevatain/note/1306203)。
由于时间关系，还有许多不完善的地方，故将项目代码放上来，望有心人进一步完善。

## 项目代码说明

在 https://github.com/MagicalBrain/AndroidProject/tree/master/app/src/main/java/com/example/administrator/myapplication01 目录下存放的是项目的java代码。

https://github.com/MagicalBrain/AndroidProject/tree/master/app/src/main/res/layout
是页面的xml代码

### 主页面 

xml代码文件：同名

java代码文件：myapplication01

写了一个使用LinearLayout简单的页面。

自定义按钮：目前无任何功能，但可作为后来新添加的功能的端口。

使用教程按钮：点击可以访问我的使用笔记（cmd markdown上的）

### 顺序选择页面

xml代码文件：同名

java代码文件：Activitydemo02

选择四等水准测量的观测顺序。

### 后前前后顺序测量页面 Activitydemo03

xml代码文件：同名

java代码文件：Activitydemo03


### 后后前前顺序测量页面 Activitydemo04

xml代码文件：同名

java代码文件：Activitydemo04

### 水准概算页面 Activitydemo05

xml代码文件：同名

java代码文件：Activitydemo05

## 其他Java文件

### 增加测站代码文件 AddCZ.java

这里封装了一些添加测站的函数，包括添加TextView、EditView一些小控件的函数，如果在实现其他测量计算（例如：四等导线……）的过程中，需要添加测站的话，可以仿照这里面的函数实现来写，从而达到快速开发的目的。

### 测站类的定义 SZcezhan.java

这里定义了测站这一类对象的各种属性。要注意的是后面Parcel容器部分，那是为了能够在各页面（Activity）之间传递该类的数据而写的。

### 测段类的定义 SZceduan.java

这里定义了测站这一类对象的各种属性。要注意的是后面Parcel容器部分，那是为了能够在各页面（Activity）之间传递该类的数据而写的。

### 限差计算函数 SZjisuan.java

这里封装了一些四等水准测量计算中用到的限差计算函数，可直接调用。

# 20190303 更新

在计算页面的结果输出中，新添加了改正数可选输出、测站测段数据可选输出。
