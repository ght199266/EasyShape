# EasyShape
## 前言
随着项目各种新增需求,Drabable里面的Shape_xx和Select_xx xml文件越来越多。这里面可能有很多重复的,也可能只是稍微变了一下,比如Shape的圆角从4dp变成5dp
又得copy出一份文件把 android:radius 属性从4dp,改成5dp，个人觉得不利于项目的维护和简洁性，希望通过简洁的代码实现就好了

### 如何使用

##### 虚线
```java
 EasyShape().with(this@MainActivity).line().setLineParams(2, Color.RED, 10, 5).target(view)
```
##### 边框
```java
 EasyShape().with(this@MainActivity)
            .setColor(Color.GREEN).setStroke(2, Color.RED).target(view)
```
##### 圆角
```java
 EasyShape().with(this@MainActivity).setColor(Color.WHITE).setRadius(10).target(view)
 //也可以这样分别设置
 EasyShape().with(this@MainActivity).setColor(Color.WHITE).setRadius(20,10,0,0).target(view)
```
##### 点击状态
```java
  EasyShape().with(this@MainActivity).setStateColor(Color.WHITE, Color.GRAY)
            .setRadius(10).target(view)
```

#### 效果图

![image](https://github.com/ght199266/MultiStateLayoutDemo/blob/master/app/src/screenshots/tt.gif)
