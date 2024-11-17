package com.example.guessnumber

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onGuessClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        val begfield = findViewById<EditText>(R.id.begin)
        val endfield = findViewById<EditText>(R.id.end)
        val begnum = begfield.text.toString().toInt()
        val endnum = endfield.text.toString().toInt()
        intent.putExtra("begin", begnum)
        intent.putExtra("end", endnum)
        startActivity(intent)
    }
}