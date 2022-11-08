package com.zebrano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zebrano.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    val first = 88
    val second = 97
    var res = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button.setOnClickListener{
            res = first + second
            viewRes()
        }
        bindingClass.button2.setOnClickListener{
            res = first - second
            viewRes()
        }
        bindingClass.button3.setOnClickListener{
            res = first * second
            viewRes()
        }
    }
    fun viewRes(){
        val str = "Результат математического действия: $res"
        if (res != 0)
            bindingClass.tvRes.text = str
    }
}