package com.zebrano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.TextView
import com.zebrano.calcapp.databinding.ActivityMainBinding
import java.lang.Math.random
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        // Только числа
        bindingClass.edValue.inputType = InputType.TYPE_CLASS_TEXT

        // Button listener
        bindingClass.button.setOnClickListener{
            if (bindingClass.edValue.text.toString() == String()) {
                return@setOnClickListener
            }
            bindingClass.tvResult.visibility = TextView.VISIBLE
            val name = bindingClass.edValue.text.toString()
            val lcName = name.lowercase()
            val sal = when(lcName) {
                "никита" -> "Уважаемый Никита, примите вашу зарплату в ${Consts.NIKITA_SALARY} рублей!"
                "гоблин" -> "Уважаемый Гоблин, примите вашу зарплату в ${Consts.GOBLIN_SALARY} рублей!"
                "павел" -> "Уважаемый Павел, примите вашу зарплату в ${Consts.PAVEL_SALARY} рублей!"
                "владимир" -> "Уважаемый Владимир, примите вашу зарплату в ${Consts.VLADIMIR_SALARY} рублей!"
                "александр" -> "Уважаемый Александр, примите вашу зарплату в ${Consts.ALEX_SALARY} рублей!"
                "валерий" -> "Уважаемый Валерий, примите вашу зарплату в ${Consts.VALERY_SALARY} рублей!"
                else -> "Имя не зарегистрировано!"
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