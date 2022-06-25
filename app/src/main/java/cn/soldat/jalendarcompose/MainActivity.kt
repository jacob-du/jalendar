package cn.soldat.jalendarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import cn.soldat.jalendar.components.JCalendar
import cn.soldat.jalendarcompose.ui.theme.JalendarComposeTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JalendarComposeTheme {
                // A surface container using the 'background' color from the theme
                val calendar = Calendar.getInstance()
                val selectedYear = remember { mutableStateOf(calendar.get(Calendar.YEAR)) }
                val selectedMonth = remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
                val selectedDay = remember { mutableStateOf(calendar.get(Calendar.DAY_OF_MONTH)) }
                JCalendar(
                    indicatorDays = listOf(11, 19, 26, 10),
                    year = selectedYear,
                    month = selectedMonth,
                    day = selectedDay,
                    onMinusMonthClick = { year, month ->
                        selectedYear.value = year
                        selectedMonth.value = month
                    },
                    onPlusMonthClick = { year, month ->
                        selectedYear.value = year
                        selectedMonth.value = month
                    },
                    onClick = { year, month, day ->
                        selectedYear.value = year
                        selectedMonth.value = month
                        selectedDay.value = day
                    }
                )
            }
        }
    }
}