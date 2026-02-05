package com.example.quizapp.util

data class Questions(
    val id: Int,
    val question: String,
    val image: String,
   val options: List<String>,
    val correctAnswer: Int
)