package com.zebrano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.TextView
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

            val sal = when(nameLower) {
                "" -> "Поле имени не заполнено!"
                Consts.WORKER -> {
                    if (code == Consts.WORKER_PASS){
                        "Уважаемый ${name}, примите ваши ${Consts.WORKER_SALARY} условных единиц."
                    } else "Пароль введен неверно!"
                }
                Consts.DIRECTOR -> {
                    if (code == Consts.DIRECTOR_PASS){
                        "Уважаемый ${name}, примите ваши ${Consts.DIRECTOR_SALARY} условных единиц."
                    } else "Пароль введен неверно!"
                }
                Consts.ENGINEER -> {
                    if (code == Consts.ENGINEER_PASS){
                        "Уважаемый ${name}, примите ваши ${Consts.ENGINEER_SALARY} условных единиц."
                    } else "Пароль введен неверно!"
                }
                else -> {
                    "Имя не распознано"
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