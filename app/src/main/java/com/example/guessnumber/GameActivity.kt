package com.example.guessnumber

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    var begin: Int = 0
    var end: Int = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        begin = intent.getIntExtra("begin", 0)
        end = intent.getIntExtra("end", 100)
        Log.d("mytag", "begin = " + begin)
        Log.d("mytag", "end = " + end)
        val tvQuestion = findViewById<TextView>(R.id.question)
        tvQuestion.text = "Ваше число больше " + ((begin+end)/2) + "?"
    }
    fun onYesNoClick(view: View) {
        val tvQuestion = findViewById<TextView>(R.id.question)
        var isright = false
        when (view.id) {
            R.id.yes -> {
                if (end-begin<=2){
                    tvQuestion.text = "Угадал: " + begin
                    isright=true
                }else {
                    begin = ((begin + end) / 2)
                }
                Log.d("mytag", "yes")
            }
            R.id.no -> {
                if (end-begin<=2){
                    begin+=1
                }else {
                    end = ((begin + end) / 2)
                }
                Log.d("mytag", "no")
            }
        }
        if (!isright) {
            if (end - begin <= 2) {
                tvQuestion.text = "Ваше число " + begin + "?"
            } else {
                tvQuestion.text = "Ваше число больше " + ((begin + end) / 2) + "?"
            }
        }

    }
}