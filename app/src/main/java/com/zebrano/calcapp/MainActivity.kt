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
            bindingClass.tvResult.text = when(lcName) {
                "никита" -> "Уважаемый Никита, примите вашу зарплату в ${rand(5000,100000)} рублей!"
                "гоблин" -> "Уважаемый Гоблин, примите вашу зарплату в ${rand(10000,1000000)} рублей!"
                "павел" -> "Уважаемый Павел, примите вашу зарплату в ${rand(100,1000)} рублей!"
                "владимир" -> "Уважаемый Владимир, примите вашу зарплату в ${rand(3000,7000)} рублей!"
                "александр" -> "Уважаемый Александр, примите вашу зарплату в ${rand(2000,10000)} рублей!"
                else -> "Имя не зарегистрировано!"
            }
            Log.d("AppLog","Button pushed! Имя: $name")
        }

    }

    fun rand(min : Int, max : Int): Int {
        val salary = Random.nextInt((max-min)+min)
        return salary
    }
}