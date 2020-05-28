package com.bizita

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bizita.ui.HomeActivity

class SplashActivity : AppCompatActivity() {

    private val mWaitHandler = Handler()
    private val context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mWaitHandler.postDelayed({
            try {
                startActivity(Intent(context, HomeActivity::class.java))
                finish()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, 2300)
    }
}
