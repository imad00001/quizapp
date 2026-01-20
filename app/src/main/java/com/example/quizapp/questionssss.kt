package com.example.quizapp

import androidx.compose.runtime.Composable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.util.Questions

@Composable
fun QuestionsScreen(userName: String, currentIndex: Int, totalQuestions: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4908FA),
                        Color(0xFF9B7AF4),
                    )
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Which Country's Flag is This?",
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 24.dp, top = 24.dp),
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(24.dp))
        Image(
            painter = painterResource(id = R.drawable.it),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(14.dp))
        LinearProgressIndicator(
            progress = { (currentIndex + 1) / totalQuestions.toFloat() },
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF00C4B4)
        )


        Text(
            text = "${currentIndex + 1} / $totalQuestions",
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 8.dp, bottom = 24.dp),
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
//        questions.options.forEachIndexed { index,option ->
//            OptionItem(
//                text = option,
//                selected = selectedOption == index,
//                onClick = {
//                    selectedOption = index
//                }
//            )
//        }
//        Button(
//            onClick = { onCheckClick(selectedOption) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            enabled = selectedOption != -1,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color(0xFF6A1B9A)
//            )
//        ) {
//            Text("CHECK", fontSize = 16.sp)
//        }

    }

}


@Preview(showBackground = true)
@Composable
fun QuestionsScreenPreview() {
    QuestionsScreen(userName = "Test User", currentIndex = 2, totalQuestions = 10)
}


