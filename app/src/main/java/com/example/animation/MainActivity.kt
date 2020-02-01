package com.example.animation

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var options: ActivityOptions? = null

    @SuppressLint("NewApi")
    override fun onClick(v: View?) {
        when (v) {
            view2 -> {
                var intent = Intent(this, Main2Activity::class.java)
                options = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(imageView, "Imagetransmission"),
                    Pair.create(close_button, "Closetransmission"),
                    Pair.create(button, "Buttontransmission")
                )
                startActivity(intent, options!!.toBundle())

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        view2.setOnClickListener(this)
    }
}
