package com.example.quizapp

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.cloudR.RetrofitClient
import com.example.quizapp.util.Questions
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val QUESTION_TIME = 10

    // ---------- QUIZ STATE ----------\
    var isQuizFinished by mutableStateOf(false)
        private set

    var questions by mutableStateOf<List<Questions>>(emptyList())
        private set

    var currentIndex by mutableStateOf(0)
        private set

    var score by mutableStateOf(0)
        private set

    // ---------- TIMER STATE ----------
    var timeLeft = mutableStateOf(QUESTION_TIME)
        private set

    var selectedOption = mutableStateOf(-1)
        private set

    private var timerJob: Job? = null

    // ---------- INIT ----------
    init {
        loadQuestions()
    }

    // ---------- LOAD FROM AWS ----------
    private fun loadQuestions() {
        viewModelScope.launch {
            try {
                questions = RetrofitClient.api.getQuestions()
                startTimer { onTimeOut() }
            } catch (e: Exception) {
                // handle error later (UI can show message)
            }
        }
    }

    // ---------- TIMER ----------
    fun startTimer(onTimeout: () -> Unit) {
        timerJob?.cancel()

        timerJob = viewModelScope.launch {
            timeLeft.value = QUESTION_TIME
            while (timeLeft.value > 0) {
                delay(1000)
                timeLeft.value--
            }
            onTimeout()
        }
    }

    fun stopTimer() {
        timerJob?.cancel()
    }

    // ---------- USER ACTIONS ----------
    fun selectOption(index: Int) {
        selectedOption.value = index
    }
    fun resetSelection() {
        selectedOption.value = -1
    }

    fun onCheckAnswer() {
        stopTimer()

        if (selectedOption.value ==
            questions[currentIndex].correctAnswer
        ) {
            score++
        }

        goToNextQuestion()
    }

    private fun onTimeOut() {
        goToNextQuestion()
    }

    private fun goToNextQuestion() {
        selectedOption.value = -1

        if (currentIndex < questions.lastIndex) {
            currentIndex++
            startTimer { onTimeOut() }
        } else {
            // quiz finished (navigate to result later)
            stopTimer()
            isQuizFinished = true
        }
    }
    fun restartQuiz() {
        currentIndex = 0
        score = 0
        selectedOption.value = -1
        isQuizFinished = false
        startTimer { onTimeOut() }
    }

}
