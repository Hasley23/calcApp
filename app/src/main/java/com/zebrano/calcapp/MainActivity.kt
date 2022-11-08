package com.zebrano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zebrano.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    val maxPerson = 90
    var currentPerson = 45
    var res = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button.setOnClickListener{
            bindingClass.tvRes.text = if (maxPerson > currentPerson)
                "Всё в порядке!" else "Превышение!"

        }
        var abda = 0
        bindingClass.button2.setOnClickListener{
            when(currentPerson){
                //45 -> bindingClass.tvRes.text = "Ровно половина!"
                //89 -> bindingClass.tvRes.text = "Почти полный зал!"
                in 0..maxPerson -> bindingClass.tvRes.text = "Всё в порядке!"
                else -> abda = 5
            }
        }
        bindingClass.button3.setOnClickListener{
            bindingClass.tvRes.text = "Это ни к чему не привело"
        }
    }
    fun viewRes(){
        val str = ": $res"
        if (res != 0)
            bindingClass.tvRes.text = str
    }
}