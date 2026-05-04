package com.example.lifehacksapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    var index = 0
    var score = 0
    lateinit var questionText: TextView
    lateinit var feedbackText: TextView

    val questions = arrayOf(
        "Coffee dehydrates you.",
        "Listening to music boots studying.",
        "Procrastination helps save time for students.",
        "We only use 10% of our brains.",
        "Closing apps saves a lot of phone battery.",
        "Mirroring helps build trust faster.",
        "Using electronic until they are below 20% actually drains the battery"
    )

    val answers = arrayOf(false, true, false, true, false)

    val explanations = arrayOf(
        "Hack:Regular coffee contributes to dehydration.",
        "Hack: Yes,instrumental music may help focus",
        "Myth: Procrastination is not helpful for students.",
        "Myth: We use most parts of our brain throught the day.",
        "Myth: Closing apps does not save battery.",
        "Myth: Mirroring is not a good way to build trust.",
        "Hack: Yes, using electronic until they are below 20% actually drains the battery"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener {
            checkAnswer(true)
        }

        mythButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            index++

            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    fun loadQuestion() {
        questionText.text = questions[index]
    }

    @SuppressLint("SetTextI18n")
    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = "Correct! 🎉\n${explanations[index]}"
            score++
        } else {
            feedbackText.text = "Wrong! ❌\n${explanations[index]}"
        }
    }
}
