package com.zijie.kotlinbase

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewFlipOne: ViewFlipper = findViewById(R.id.flipper_one)
        val viewFliptwo: ViewFlipper = findViewById(R.id.flipper_two)

        var arrayOf = arrayOf(
            "早上，曹**接单成功！3天话务员360元",
            "中午，刘**接单成功！2天打包分拣440元",
            "下午，张**接单成功！2天打包分拣440元",
            "晚上，林**接单成功！1天充场100元",
            "半夜，张**接单成功！2天问卷凋查230元",
            "刚才，崔**接单成功！1天充场180元"
        )
        var arrayOf1 = arrayOf(
            "中午，刘**接单成功！2天打包分拣440元",
            "下午，张**接单成功！2天打包分拣440元",
            "晚上，林**接单成功！1天充场100元",
            "半夜，张**接单成功！2天问卷凋查230元",
            "刚才，崔**接单成功！1天充场180元",
            "早上，曹**接单成功！3天话务员360元"
        )
        for (item in arrayOf) {
            val tvText: TextView =
                LayoutInflater.from(this).inflate(R.layout.rb_home_message_item_layout, null) as TextView
            tvText.setText(item)
            viewFlipOne.addView(tvText)
        }

        for (item in arrayOf1) {
            val tvText: TextView =
                LayoutInflater.from(this).inflate(R.layout.rb_home_message_item_layout, null) as TextView;
            tvText.setText(item)
            viewFliptwo.addView(tvText)
        }
        viewFlipOne.startFlipping()
        viewFliptwo.startFlipping()
        viewFlipOne.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                if (v != null) {
                    if (v.id == R.id.flipper_one){

                    }
                }
            }

        } )

        viewFlipOne.setOnClickListener { if (it != null){

        } }
    }


}
