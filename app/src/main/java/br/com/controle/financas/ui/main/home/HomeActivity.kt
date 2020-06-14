package br.com.controle.financas.ui.main.home

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Slide
import br.com.controle.financas.R


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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