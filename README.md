# EasyShape

### 前言
随着项目各种新增需求页面 Drabable里面的Shape_xx和Select_xx xml文件越来越多,有重复的,也可能只是稍微变了一下,比如Shape的圆角从4dp变成5dp，这时候
又得copy出一份文件把 android:radius 属性从4dp,改成5dp.看着一堆密密麻麻的shape select 文件,要是能通过简洁的代码实现就好了。

#### 如何使用

#### 有三种类型

```java
//矩形默认
rectangle()
//虚线
line()
//圆型
oval()
```

##### 虚线
```java
 EasyShape().line().setLineParams(2, Color.RED, 10, 5).target(view)
```
##### 边框
```java
 EasyShape().setColor(Color.GREEN).setStroke(2, Color.RED).target(view)
```
##### 圆角
```java
 EasyShape().setColor(Color.WHITE).setRadius(10).target(view)
 //也可以这样分别设置
 EasyShape().with(this@MainActivity).setColor(Color.WHITE).setRadius(20,10,0,0).target(view)
```
##### 点击状态
```java
  EasyShape().with(this@MainActivity).setStateColor(Color.WHITE, Color.GRAY)
            .setRadius(10).target(view)
```
##### 点击状态
```java
  EasyShape().oval().setColor(Color.RED).target(btn_e)
```

#### 效果图

![image](https://github.com/ght199266/EasyShape/blob/master/app/src/picture/shape.gif)
