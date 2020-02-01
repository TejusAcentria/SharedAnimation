package com.example.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.fragments.FirstFragment
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity(), Animation.AnimationListener, View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            b1 -> {
                show_view_one()
            }
            blue_button -> {

                val firstFragment = FirstFragment()

                firstFragment.show(supportFragmentManager, "dialog")

            }
        }
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
        if (animation == animBlink) {
        }
    }

    override fun onAnimationStart(animation: Animation?) {
        if (animation == animBlink) {
        }
    }

    var animBlink: Animation? = null
    var objectAnimator: ObjectAnimator? = null
    var animMove: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main2)
        Handler().postDelayed({

            show_text_values()

        }, 900)


        animBlink = AnimationUtils.loadAnimation(
            this,
            R.anim.blink
        )
        animBlink!!.setAnimationListener(this)


        object_animator()


        b1.setOnClickListener(this)
        blue_button.setOnClickListener(this)

        animMove = AnimationUtils.loadAnimation(this, R.anim.move);
    }

    private fun show_text_values() {
        if (textView3.visibility == View.INVISIBLE) {
            textView3.visibility = View.VISIBLE
        }

        if (textView4.visibility == View.INVISIBLE) {
            textView4.visibility = View.VISIBLE
        }
        linear_one.visibility = View.VISIBLE
        linear_one.startAnimation(animMove)
    }

    private fun object_animator() {
        objectAnimator = ObjectAnimator.ofInt(
            progress_bar, "progress",
            progress_bar!!.getProgress(), 100
        ).setDuration(2000)

        objectAnimator!!.addUpdateListener { valueAnimator ->
            val progress = valueAnimator.animatedValue as Int
            progress_bar!!.setProgress(progress)
            if (progress == 100) {
                cancel_tick.visibility = View.INVISIBLE
                complete_tick.visibility = View.VISIBLE

                if (complete_tick.visibility == View.VISIBLE) {
                    Handler().postDelayed({
                        show_view_animation()
                    }, 1000)
                }

            }
        }
    }

    private fun show_view_one() {
        if (b1.visibility == View.VISIBLE) {
            b1.visibility = View.INVISIBLE
            frame.visibility = View.VISIBLE
            close_layout.visibility = View.VISIBLE
            objectAnimator!!.start()
        }
    }

    private fun show_view_animation() {
        b1.visibility = View.INVISIBLE
        frame.visibility = View.INVISIBLE
        close_layout.visibility = View.INVISIBLE
        blue_button.visibility = View.VISIBLE
        play.startAnimation(animBlink)
    }


}
