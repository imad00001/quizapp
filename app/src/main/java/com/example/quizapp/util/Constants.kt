import com.example.quizapp.R
import com.example.quizapp.util.Questions

object Constants {

    fun getQuestions(): MutableList<Questions> {

        return mutableListOf(

            Questions(
                id = 1,
                question = "What country does this flag belong to?",
                R.drawable.ar,
                options = listOf("Brazil", "Argentina", "Italy", "France"),
                correctAnswer = 1
            ),

            Questions(
                id = 2,
                question = "What country does this flag belong to?",
                R.drawable.`in`,
                options = listOf("Germany", "India", "Brazil", "Romania"),
                correctAnswer = 2
            ),

            Questions(
                id = 3,
                question = "What country does this flag belong to?",
                R.drawable.fr,
                options = listOf("Belgium", "France", "Germany", "Italy"),
                correctAnswer = 2
            ),

            Questions(
                id = 4,
                question = "What country does this flag belong to?",
                R.drawable.fi,
                options = listOf("Finland", "Ecuador", "Mexico", "Spain"),
                correctAnswer = 1
            ),

            Questions(
                id = 5,
                question = "What country does this flag belong to?",
                R.drawable.ng,
                options = listOf("Sweden", "Nigeria", "Finland", "Denmark"),
                correctAnswer = 2
            ),

            Questions(
                id = 6,
                question = "What country does this flag belong to?",
                R.drawable.ar,
                options = listOf("Netherlands", "Italy", "Russia", "France"),
                correctAnswer = 3
            ),

            Questions(
                id = 7,
                question = "What country does this flag belong to?",
                R.drawable.ec,
                options = listOf("Nepal", "ecuador", "India", "Bangladesh"),
                correctAnswer = 2
            ),

            Questions(
                id = 8,
                question = "What country does this flag belong to?",
                R.drawable.it,
                options = listOf("Mexico", "Ireland", "Italy", "France"),
                correctAnswer = 2
            ),

            Questions(
                id = 9,
                question = "What country does this flag belong to?",
                R.drawable.br,
                options = listOf("Ghana", "Nigeria", "Kenya", "South Africa"),
                correctAnswer = 1
            ),

            Questions(
                id = 10,
                question = "What country does this flag belong to?",
                R.drawable.ro,
                options = listOf("Bulgaria", "Hungary", "Romania", "Chad"),
                correctAnswer = 3
            )
        )
    }
}
