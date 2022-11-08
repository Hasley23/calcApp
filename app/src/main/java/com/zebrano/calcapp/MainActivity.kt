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
        bindingClass.edValue.inputType = InputType.TYPE_CLASS_NUMBER
        // начальное число
        bindingClass.edValue.setText("100")

        // Button listener
        bindingClass.button.setOnClickListener{
            if (bindingClass.edValue.text.toString() == String()) {
                return@setOnClickListener
            }
            bindingClass.tvResult.visibility = TextView.VISIBLE
            val num = bindingClass.edValue.text.toString().toInt()
            bindingClass.tvResult.text = when(num) {
                in 0..10 -> "So bad..."
                in 11..20 -> "Not so good"
                in 21..30 -> "aww..."
                in 31..40 -> "just try already"
                in 41..50 -> "Medium"
                in 51..60 -> "Medium well"
                in 61..70 -> "Good"
                in 71..80 -> "So good"
                in 81..90 -> "So fuckin good"
                in 91..100 -> "Excellent!"
                else -> "The app doesn't know..."
            }
            Log.d("AppLog","Button pushed! num = $num")
        }

    }
}