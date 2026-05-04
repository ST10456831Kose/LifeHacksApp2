package com.example.lifehacksapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lifehacksapp.R

class ScoreActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)

        val message = if (score >= 4) "Master Hacker! 💪" else "Keep practising!"

        scoreText.text = "Score: $score / $total\n$message"

        reviewButton.setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }
    }
}
