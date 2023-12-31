package marek.kurs.android.tasks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import marek.kurs.android.tasks.model.Task

var taskList = mutableStateListOf<Task>()
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addTaskToList(intent)

        setContent {
            HomeView()
        }
    }

    //funkcja wywolywana gdy przechodzę do tego okna przyciskiem wstecz na telefonie
    //jeżeli nie dodam tutaj taska do listy, wyświetli puste okno (gdybym zapisywał listę, wyświetli starą listę bez nowego taska)
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { addTaskToList(intent) }
    }

    private fun addTaskToList(intent: Intent)
    {
        //obsługa task jest null
        val task = intent.getSerializableExtra("task") as? Task
        //dodaje task tylko wtedy gdy task nie jest null
        task?.let {
            taskList.add(it)
        }
    }

    @Composable
    fun HomeView(){
        val context: Context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize()){
            if (taskList.isNotEmpty())
                LazyColumnArea()
            else
                Text(text = "Task list is empty",
                    modifier = Modifier.align(Alignment.Center)
                    )

        FloatingActionButton(onClick = {
                val intent: Intent = Intent(context, TaskActivity::class.java)
                startActivity(intent)
                //finish()    //zamyka to okno po przejściu do nowego; nie chcę go zamykać, tylko schować
            //żeby po kliknięciu na wstecz w telefonie apka tam się otworzyła

            }, modifier = Modifier
            .padding(10.dp)
            .align(Alignment.BottomEnd)

            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    }

    @Composable
    fun LazyColumnArea(){
        Column(modifier = Modifier.padding(horizontal = 20.dp)){
            Text(text = "Tasks",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp, start = 20.dp)
                )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                contentPadding = PaddingValues(vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                if (taskList.isNotEmpty())
                    items(items = taskList) { t ->
                        TextBoxes(task = t)
                    }
            }
        }
    }

    @Composable
    fun TextBoxes(task: Task){
        Card(border = BorderStroke(width = 1.dp, color = Color.LightGray),
            colors = CardDefaults.cardColors(containerColor = task.colour),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)) {
            Column(modifier = Modifier.padding(16.dp)){
                Text(
                    text = task.name,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                Text(
                    text = task.description,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }

}
