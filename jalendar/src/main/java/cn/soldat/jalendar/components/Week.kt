package cn.soldat.jalendar.components

/**
 * @Author: Jacob Du
 * @Date: 2022/6/22 17:25
 * @Desc:
 * @Website: https://www.soldat.cn
 */


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cn.soldat.jalendar.WeekFields
import java.util.*

@Composable
fun Week() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val calendar = Calendar.getInstance()
        calendar.get(Calendar.WEEK_OF_YEAR)
        val todayWeek = calendar.get(Calendar.DAY_OF_WEEK)
        Day(week = WeekFields.SUN,day = 6)
        Day(week = WeekFields.MON, day = 7)
        Day(week = WeekFields.TUE, day = 8)
        Day(week = WeekFields.WED, day = 9)
        Day(week = WeekFields.THU, day = 10, indicator = true)
        Day(week = WeekFields.FRI, day = 11, selected = true, indicator = true)
        Day(week = WeekFields.SAT, day = 12)
    }
}

@Preview
@Composable
fun WeekPreview() {
    Week()
}

