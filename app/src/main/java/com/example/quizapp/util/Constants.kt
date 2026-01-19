import com.example.quizapp.util.Questions
import com.example.quizapp.R

object Constants {
    fun getQuestions(): MutableList<Questions> {
        val questions = mutableListOf<Questions>()

        val q1 = Questions(
            id = 1,
            question = "What country does this flag belong to?",
            R.drawable.`in`,
            options = listOf("India", "USA", "UK", "France"),
            correctAnswer = 0
        )

        questions.add(q1)
        return questions
    }
}
