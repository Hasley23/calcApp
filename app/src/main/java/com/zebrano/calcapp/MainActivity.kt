package com.zebrano.calcapp

import android.app.UiModeManager.MODE_NIGHT_NO
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.NightMode
import com.zebrano.calcapp.databinding.ActivityMainBinding
import java.lang.Math.random
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        // Выключаем темную тему
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }

    fun rand(min : Int, max : Int): Int {
        val salary = Random.nextInt((max-min)+min)
        return salary
    }
}