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
    private lateinit var btn_e: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_a = findViewById(R.id.btn_a)
        btn_b = findViewById(R.id.btn_b)
        btn_c = findViewById(R.id.btn_c)
        btn_d = findViewById(R.id.btn_d)
        btn_e = findViewById(R.id.btn_e)


        //虚线
        EasyShape().line().setLineParams(2, Color.RED, 10, 5).target(btn_a)
        //边框
        EasyShape().rectangle().setColor(Color.GREEN).setStroke(2, Color.RED).target(btn_b)
        //圆角
//        EasyShape().rectangle().setColor(Color.WHITE).setRadius(10).target(btn_c)
        EasyShape().rectangle().setColor(Color.WHITE).setRadius(40,30,20,5).target(btn_c)
        //传入默认的颜色和按下的颜色
        EasyShape().rectangle().setStateColor(Color.WHITE, Color.GRAY).setRadius(10).target(btn_d)
        //圆
        EasyShape().oval().setColor(Color.RED).target(btn_e)


    }

}
