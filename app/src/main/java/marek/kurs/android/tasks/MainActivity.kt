package marek.kurs.android.tasks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //startActivity(Intent(LocalContext.current, HomeActivity::class.java))
            //StartHomeActivity()
            StartExcerciseActivity()
        }
    }

    @Composable
    fun StartExcerciseActivity(){
        val context: Context = LocalContext.current
        val intent: Intent = Intent(context, ExerciseActivity::class.java)
        var txt by remember{ mutableStateOf<String>("")}
        intent.putExtra("exerciseActivityText", txt)

        Column() {
            TextField(value = txt, onValueChange = { txt = it },
               label = {Text(text = "Wpisz coś")} )
            Button(onClick = { startActivity(intent) }) {
                Text(text = "Start exercise window")
            }
        }
    }

    @Composable
    fun StartHomeActivity(){
        val context: Context = LocalContext.current
        val intent: Intent = Intent(context, HomeActivity::class.java)
        intent.putExtra("infoText", "This text was sent from MainActivity")

        Button(onClick = { startActivity((intent)) }) {
            Text(text = "Start home activity")
        }
    }
}