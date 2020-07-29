package br.com.controle.financas.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.controle.financas.R
import com.github.emerson.financas.debug.java.EmailPasswordActivity


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "irra", Toast.LENGTH_LONG).show()
        val intent = Intent(this, EmailPasswordActivity::class.java)
        startActivity(intent)

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