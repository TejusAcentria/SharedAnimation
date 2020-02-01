package com.example.animation.fragments


import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.example.animation.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : DialogFragment() {
    @SuppressLint("NewApi")

    var linearLayout: LinearLayout? = null
    var next_button: Button? = null
    var animMove: Animation? = null
    var animZoomin: Animation? = null
    var options: ActivityOptions? = null

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.setCancelable(false)
            dialog.window!!.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.attributes.windowAnimations = R.style.FullScreenDialogStyle
            val window = this.dialog.window
            val params = window!!.attributes as WindowManager.LayoutParams
            window.attributes = params
            window.setGravity(Gravity.BOTTOM)
            window.setBackgroundDrawableResource(android.R.color.transparent)
            linearLayout!!.startAnimation(animMove)
            view3!!.startAnimation(animZoomin)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        next_button = view.findViewById(R.id.button2)
        linearLayout = view.findViewById(R.id.linearLayout)
        animMove = AnimationUtils.loadAnimation(activity, R.anim.move);
        animZoomin = AnimationUtils.loadAnimation(activity, R.anim.zoom_in)

        return view
    }


}
