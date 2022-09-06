package com.wetharityoptimus.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Thread {
            Thread.sleep(2000)
            runOnUiThread {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
        }.start()
    }
}