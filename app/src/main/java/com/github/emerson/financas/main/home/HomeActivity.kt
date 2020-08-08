package com.github.emerson.financas.main.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.emerson.financas.R


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "irra", Toast.LENGTH_LONG).show()

        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }

    //Your Slide animation
//    fun setAnimation() {
//        val slide = Slide()
//        slide.slideEdge = Gravity.LEFT
//        slide.duration = 400
//        slide.interpolator = DecelerateInterpolator()
//        window.exitTransition = slide
//        window.enterTransition = slide
//    }
}