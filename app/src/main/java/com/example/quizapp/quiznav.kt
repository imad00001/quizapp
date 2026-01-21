package com.example.quizapp

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.util.*


@Composable
fun quizNavigation() {

    val navController = rememberNavController()

    val questionsList = remember { Constants.getQuestions() }
    var currentIndex by remember { mutableStateOf(0) }

    NavHost(
        navController = navController,
        startDestination = "Welcome"
    ) {

        composable("Welcome") {
            QuizWel(
                onStartClick = { name ->
                    navController.navigate("questions/$name")
                }
            )
        }

        composable("questions/{userName}") {

            QuestionsScreen(
                questions = questionsList[currentIndex],
                currentIndex = currentIndex,
                totalQuestions = questionsList.size,
                onCheckClick = { selectedOption ->
                    if (selectedOption ==
                        questionsList[currentIndex].correctAnswer
                    ) {
                        // correct answer logic (score++)
                    }

                    if (currentIndex < questionsList.lastIndex) {
                        currentIndex++
                    } else {
                        // quiz finished → navigate to result screen later
                    }
                }
            )
        }
    }
}
