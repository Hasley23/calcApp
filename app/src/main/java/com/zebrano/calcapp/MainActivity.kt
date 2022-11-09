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

        // Только числа
        bindingClass.edValue.inputType = InputType.TYPE_CLASS_TEXT
        bindingClass.edCode.inputType = InputType.TYPE_CLASS_NUMBER

        // Button listener
        bindingClass.button.setOnClickListener{
            if (bindingClass.edValue.text.toString() == String()) {
                return@setOnClickListener
            }
            bindingClass.tvResult.visibility = TextView.VISIBLE
            val name = bindingClass.edValue.text.toString()
            Log.d("AppLog", "name = $name")
            val code = bindingClass.edCode.text.toString()

            val nameLower = name.lowercase(Locale.ROOT)

            val sal : String
            when(nameLower) {
                "" -> {
                    sal = "Введите имя!"
                }
                Consts.WORKER -> {
                    if (code == Consts.WORKER_PASS){
                        bindingClass.userIcon.setImageResource(R.drawable.jack)
                        sal = "Уважаемый ${name}, примите ваши ${Consts.WORKER_SALARY} условных единиц."
                    } else sal = "Пароль введен неверно!"
                }
                Consts.DIRECTOR -> {
                    if(code == Consts.DIRECTOR_PASS) {
                        bindingClass.userIcon.setImageResource(R.drawable.seb)
                        sal = "Уважаемый ${name}, примите ваши ${Consts.DIRECTOR_SALARY} условных единиц."
                    } else sal = "Пароль введен неверно!"
                }
                Consts.ENGINEER -> {
                    if(code == Consts.ENGINEER_PASS) {
                        bindingClass.userIcon.setImageResource(R.drawable.petr)
                        sal = "Уважаемый ${name}, примите ваши ${Consts.ENGINEER_SALARY} условных единиц."
                    } else sal = "Пароль введен неверно!"
                }
                else -> {
                    bindingClass.userIcon.setImageResource(R.drawable.unknown)
                    sal = "Имя не распознано!"
                }
            }
            bindingClass.tvResult.text = sal
            Log.d("AppLog","Button pushed! Имя: $name")
        }

    }

    fun rand(min : Int, max : Int): Int {
        val salary = Random.nextInt((max-min)+min)
        return salary
    }
}