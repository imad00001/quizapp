package com.example.quizapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun quizNavigation(){
  val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Welcome"
    ){
      composable("Welcome"){
          QuizWel(
              onStartClick = {name ->
                  navController.navigate("questions/$name"){
                      popUpTo("Welcome")
                      {inclusive = true}
                  }
              }

          )
      }
        composable("questions/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            QuestionsScreen(
                userName = userName,
                currentIndex = 2, totalQuestions = 10
            )
        }


    }



}