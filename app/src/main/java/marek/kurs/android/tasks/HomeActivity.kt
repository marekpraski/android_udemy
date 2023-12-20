package marek.kurs.android.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val welcomeText: String? = intent.getStringExtra("infoText")

        setContent {
            Welcome(welcomeText)

        }
    }

    @Composable
    fun Welcome(txt: String?){
        val defaultText: String = "this is default HomeActivity text"   //gdyby przekazany tekst był null
        Text(text = txt ?: defaultText)
    }
}
