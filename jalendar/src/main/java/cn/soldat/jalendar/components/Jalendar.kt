package cn.soldat.jalendar.components

/**
 * @Author: Jacob Du
 * @Date: 2022/6/22 16:49
 * @Desc:
 * @Website: https://www.soldat.cn
 */


import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JCalendar(
    modifier: Modifier = Modifier,
    year: MutableState<Int>,
    month: MutableState<Int>,
    day: MutableState<Int>,
    indicatorDays: List<Int> = emptyList(),
    onMinusMonthClick: (year: Int, month: Int) -> Unit,
    onPlusMonthClick: (year: Int, month: Int) -> Unit,
    onClick: (year: Int, month: Int, day: Int) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                month.value = if (month.value == 0) 11 else month.value - 1
                if (month.value == 11) --year.value
                day.value = 1
                onMinusMonthClick(year.value, month.value)
            }) {
                Icon(imageVector = Icons.Rounded.ArrowBackIos, contentDescription = null)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${month.value + 1} 月")
                Text(text = "${year.value}", fontSize = 12.sp, color = Color.LightGray)
            }
            IconButton(onClick = {
                day.value = 1
                month.value = if (month.value == 11) 0 else month.value + 1
                if (month.value == 0) ++year.value
                onPlusMonthClick(year.value, month.value)
            }) {
                Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
            }
        }
        Month(
            year = year.value,
            month = month.value,
            day = day.value,
            onClick = { itMonth, itDay -> onClick(year.value, itMonth, itDay) },
            indicatorDays = indicatorDays
        )
    }
}
