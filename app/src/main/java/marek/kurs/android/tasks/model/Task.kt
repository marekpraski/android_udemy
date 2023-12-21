package marek.kurs.android.tasks.model

import androidx.compose.ui.graphics.Color
import java.io.Serializable
import java.util.UUID

data class Task(
    val name: String,
    val description: String,
    val colour: Color,
    val id: String = UUID.randomUUID().toString()
): Serializable
