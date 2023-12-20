package marek.kurs.android.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class ExerciseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sentText: String? = intent.getStringExtra("exerciseActivityText")
        setContent {
            DisplayExerciseWindow(text = sentText)
        }
    }
    
    @Composable
    fun DisplayExerciseWindow(text: String?){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxSize()
        ){
            Text(text = text ?: "No text sent from MainActivity")
        }
    }
}
