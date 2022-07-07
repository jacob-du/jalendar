package cn.soldat.jalendarcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cn.soldat.jalendar.animated.JalendarState
import cn.soldat.jalendar.animated.components.AnimatedJalendar
import cn.soldat.jalendarcompose.ui.theme.JalendarComposeTheme
import java.time.LocalDate
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JalendarComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val state = remember { JalendarState() }
                    AnimatedJalendar(state = state)
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(text = state.selected.toString())
                }
            }
        }
    }
}