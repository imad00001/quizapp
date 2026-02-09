package com.example.quizapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {

        composable("welcome") {
            QuizWel(
                onStartClick = { name ->
                    navController.navigate("quiz/$name")
                }
            )
        }

        composable("quiz/{userName}") { backStackEntry ->
            val userName =
                backStackEntry.arguments?.getString("userName") ?: ""

            QuizFlow(userName = userName)
        }
    }
}

