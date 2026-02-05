package com.example.quizapp.cloudR

import com.example.quizapp.util.Questions
import retrofit2.http.GET

interface QuizApi {
    @GET("questions.json")
    suspend fun getQuestions(): List<Questions>
}