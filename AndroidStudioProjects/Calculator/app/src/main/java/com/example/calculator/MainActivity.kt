package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.btn1)
        b1.setOnClickListener {
            val et1 = findViewById<EditText>(R.id.et1)
            val et2 = findViewById<EditText>(R.id.et2)
            val add = et1.getText().toString().toDouble()
            val add2 = et2.getText().toString().toDouble()
            val ans = add + add2
            val tv1 = findViewById<TextView>(R.id.tv1)
            tv1.setText("$ans")
        }
        val b2 = findViewById<Button>(R.id.btn2)
        b2.setOnClickListener {
            val et1 = findViewById<EditText>(R.id.et1)
            val et2 = findViewById<EditText>(R.id.et2)
            val sub = et1.getText().toString().toDouble()
            val sub2 = et2.getText().toString().toDouble()
            val ans = sub - sub2
            val tv1 = findViewById<TextView>(R.id.tv1)
            tv1.setText(" $ans")
        }
        val b3 = findViewById<Button>(R.id.btn3)
        b3.setOnClickListener {
            val et1 = findViewById<EditText>(R.id.et1)
            val et2 = findViewById<EditText>(R.id.et2)
            val mult = et1.getText().toString().toDouble()
            val ply = et2.getText().toString().toDouble()
            var answer = mult * ply
            var tv1 = findViewById<TextView>(R.id.tv1)
            tv1.setText("$answer")

        }
        val b4 = findViewById<Button>(R.id.btn4)
        b4.setOnClickListener {
            val et1 = findViewById<EditText>(R.id.et1)
            val et2 = findViewById<EditText>(R.id.et2)
            val div = et1.getText().toString().toDouble()
            val vis = et2.getText().toString().toDouble()
            val dvans = div / vis
            val tv1 = findViewById<TextView>(R.id.tv1)
            tv1.setText(" $dvans")


        }
    }
}