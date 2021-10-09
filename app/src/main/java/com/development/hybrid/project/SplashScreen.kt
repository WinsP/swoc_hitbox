package com.development.hybrid.project

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.development.hybrid.project.views.auth.LoginActivity

class SplashScreen : AppCompatActivity() {

    private val mHandler = Handler(Looper.getMainLooper())
    private val mLauncher: Launcher = Launcher()

    override fun onStart() {
        super.onStart()
        mHandler.postDelayed(mLauncher, SPLASH_DELAY.toLong())
    }

    override fun onStop() {
        mHandler.removeCallbacks(mLauncher)
        super.onStop()
    }

    private fun launch() {
        if (!isFinishing) {
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
            finish()
        }
    }

    private inner class Launcher : Runnable {
        override fun run() {
            launch()
        }
    }

    companion object {
        private const val SPLASH_DELAY = 2000
    }

}