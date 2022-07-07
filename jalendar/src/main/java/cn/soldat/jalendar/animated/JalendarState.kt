package cn.soldat.jalendar.animated

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.time.LocalDate

class JalendarState(
    initialDate: LocalDate = LocalDate.now(),
    val years: IntRange = IntRange(initialDate.year - 10, initialDate.year + 10)
) {
    var selected by mutableStateOf(initialDate)
    var showYearPicker by mutableStateOf(false)
}