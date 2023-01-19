package com.example.customview

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.customview.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    private var current = 0L




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels.toFloat()
        var height = displayMetrics.heightPixels.toFloat()

        binding.customViewOne.setDimention(width,height)

        binding.button.setOnClickListener { binding.customViewOne.movingToNextStep(50f) }
        binding.button2.setOnClickListener { binding.customViewOne.movingToNextStep(10f) }



/*
        binding.customViewOne.setPeriod(PERIOD)

        GlobalScope.launch {
            while (current < PERIOD * REPEAT) {
                current += INTERVAL
                binding.customViewOne.setCurrent(current)

                delay(INTERVAL)
            }
        }*/



    }
    private companion object {

        private const val INTERVAL = 100L
        private const val PERIOD = 1000L * 10 // 10 sec
        private const val REPEAT = 1 // 10 times
    }

}