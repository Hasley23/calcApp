package com.zebrano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.TextView
import com.zebrano.calcapp.databinding.ActivityMainBinding

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
            val num = bindingClass.edValue.text.toString()
            bindingClass.tvResult.text = when(num) {
                "Никита" -> "Уважаемый Никита, примите вашу зарплату в 1 000 рублей!"
                "Гоблин" -> "Уважаемый Гоблин, примите вашу зарплату в 10 000 рублей!"
                "Павел" -> "Уважаемый Павел, примите вашу зарплату в 10 000 рублей!"
                "Владимир" -> "Уважаемый Владимир, примите вашу зарплату в 16 000 рублей!"
                "Александр" -> "Уважаемый Александр, примите вашу зарплату в 5 000 рублей!"
                else -> "Имя не зарегистрировано!"
            }
            Log.d("AppLog","Button pushed! Имя: $num")
        }

    }
}