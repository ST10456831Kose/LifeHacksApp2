package com.example.lifehacksapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
//        { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val layout = findViewById<LinearLayout>(R.id.reviewLayout)

        val questions = arrayOf(
            "Putting your phone in rice fixes water damage",
            "Using keyboard shortcuts improves productivity",
            "Drinking coffee completely dehydrates you",
            "Writing tasks down improves memory",
            "Charging phone overnight destroys battery"
        )

        val answers = arrayOf(false, true, false, true, false)

        for (i in questions.indices) {
            val tv = TextView(this)
            val answerText = if (answers[i]) "Hack" else "Myth"
            tv.text = "${questions[i]}\nAnswer: $answerText\n"
            tv.setPadding(0, 0, 0, 20)
            layout.addView(tv)
        }
    }
}