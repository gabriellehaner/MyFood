package com.example.myfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        Thread.sleep(2000)

        setTheme(R.style.Theme_MyFood)

        supportActionBar!!.hide()
        val decorView = window.decorView
        val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        decorView.systemUiVisibility = uiOptions

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}