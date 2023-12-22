package marek.kurs.android.tasks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import marek.kurs.android.tasks.model.Task

class TaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddTask()

        }
    }
    @Composable
    fun AddTask(){
        var taskName: MutableState<String> = remember{ mutableStateOf("")}
        var taskDescription: MutableState<String> = remember{ mutableStateOf("")}
        var taskColor: MutableState<Color> = remember{ mutableStateOf(Color.White)}
        val context: Context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding((10.dp))
        ) {
            Text(text = "New task",
                fontSize = 30.sp,
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            TextBoxes(taskColor.value, taskName, taskDescription)

            CircularButtons(taskColor)

            Button(onClick = {
                 val t: Task = Task(name = taskName.value,
                     description = taskDescription.value,
                     colour = taskColor.value)
                val intent: Intent = Intent(context, HomeActivity::class.java)
                intent.putExtra( "task", t)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)  //nie zamknąłem Home, teraz tam wracam
                startActivity(intent)
                finish()    //zamyka to okno po przejściu do nowego

                Log.d("taskActivity", "utworzony tas")
                             },

                modifier = Modifier.fillMaxWidth()
                ) {
                Text(text = "Save")

            }
        }
    }

    @Composable
    fun TextBoxes(bgColor: Color, taskName: MutableState<String>, taskDescr: MutableState<String>){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = bgColor)
        ) {
            OutlinedTextField(value = taskName.value,
                onValueChange = { taskName.value = it },
                label = {Text(text = "Task name")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
            )
            OutlinedTextField(
                value = taskDescr.value,
                onValueChange = { taskDescr.value = it },
                label = {Text(text = "Task description")},
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    @Composable
    fun CircularButtons(color: MutableState<Color>){
        val colourList = listOf(Color.White, Color.Cyan,Color.Yellow, Color.Magenta, Color.LightGray,
            Color.Green, Color.Red)

        LazyRow(contentPadding = PaddingValues(vertical= (10.dp))){

//            items(count = colourList.size){index->
//                ColourButton(taskColour = color, buttonColour = colourList[index])
//            }

            items(items = colourList){buttonColour->
                ColourButton(color, buttonColour)
            }
        }
    }

    @Composable
    fun ColourButton(taskColour: MutableState<Color>, buttonColour: Color){
        Button(onClick = { taskColour.value = buttonColour },
            modifier = Modifier
                .size(width = 30.dp, height = 30.dp)
            ,
            border = BorderStroke(width = if(taskColour.value == buttonColour) 2.dp else 1.dp
                , color = if(taskColour.value == buttonColour) Color.Black else Color.LightGray),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = buttonColour)
        ) {
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}

