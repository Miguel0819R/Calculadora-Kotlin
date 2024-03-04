package com.example.practica11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0-none, 1->plus, 2->rest, 3-> mult, 4->div
    var operation: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var  tv_num2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.btnClear)
        val btnIgual: Button = findViewById(R.id.btnEquals)
        btnIgual.setOnClickListener{
            var numero2 = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(operation){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }
            tv_num2.setText(resp.toString())
            if (operation == 0) {
                tv_num1.setText("")
            }
        }
        btnBorrar.setOnClickListener{
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            operation = 0
        }
    }

    fun onClickDigito(view: View){

        var num2: String = tv_num2.text.toString()
        when(view.id){
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
            R.id.btnPunto -> tv_num2.setText(num2 + ".")

        }


    }

    fun onClickOperation(view: View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
            R.id.btnMas ->{
                tv_num1.setText(num2_text + "+")
                operation = 1
            }
            R.id.btnMenos ->{
                tv_num1.setText(num2_text + "-")
                operation = 2
            }
            R.id.btnPor ->{
                tv_num1.setText(num2_text + "*")
                operation = 3
            }
            R.id.btnSlash ->{
                tv_num1.setText(num2_text + "/")
                operation = 4
            }
        }
        if (operation != 0) {
            numero1 = tv_num1.text.toString().substring(0, tv_num1.text.toString().length - 1).toDouble()
        }
    }
}