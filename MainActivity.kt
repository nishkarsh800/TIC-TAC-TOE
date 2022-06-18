package com.example.crosszero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // logo & text coming from up to down
        image.translationY = -2000f
        textView2.translationY = -2000f

        image.animate().translationY(0f).duration = 2000
        textView2.animate().translationY(0f).duration = 2000

        // going from home screen to next screen
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this,StartActivity::class.java)
                startActivity(intent)
            },4000)
    }
}
