package com.lly.easyshape

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.lly.mylibrary.shape.EasyShape

class MainActivity : AppCompatActivity() {

    private lateinit var btn_a: Button
    private lateinit var btn_b: Button
    private lateinit var btn_c: Button
    private lateinit var btn_d: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_a = findViewById(R.id.btn_a)
        btn_b = findViewById(R.id.btn_b)
        btn_c = findViewById(R.id.btn_c)
        btn_d = findViewById(R.id.btn_d)


        //虚线
        EasyShape().with(this@MainActivity).line().setLineParams(2, Color.RED, 10, 5).target(btn_a)
        //边框
        EasyShape().with(this@MainActivity)
            .setColor(Color.GREEN).setStroke(2, Color.RED).target(btn_b)
        //圆角
        EasyShape().with(this@MainActivity).setColor(Color.WHITE)
            .setRadius(10).target(btn_c)
        //也可以这样
//        EasyShape().with(this@MainActivity).setColor(Color.WHITE)
//            .setRadius(20,10,0,0)
        //按压颜色
        EasyShape().with(this@MainActivity).setStateColor(Color.WHITE, Color.GRAY)
            .setRadius(10).target(btn_d)

    }

}
