package com.azp.recyclerviewkotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        val fruitName = intent.getStringExtra("NAME")

        val name = findViewById<TextView>(R.id.name).apply {
            text = fruitName
        }
    }
}
