package com.example.quizapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val QUESTION_TIME = 10

    var timeLeft = mutableStateOf(QUESTION_TIME)
        private set

    var selectedOption = mutableStateOf(-1)
        private set

    private var timerJob: Job? = null

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

    fun selectOption(index: Int) {
        selectedOption.value = index
    }

    fun resetSelection() {
        selectedOption.value = -1
    }

    fun stopTimer() {
        timerJob?.cancel()
    }
}
