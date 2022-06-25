package cn.soldat.jalendar.components

/**
 * @Author: Jacob Du
 * @Date: 2022/6/23 09:35
 * @Desc:
 * @Website: https://www.soldat.cn
 */


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cn.soldat.jalendar.MonthFields
import cn.soldat.jalendar.WEEKS
import cn.soldat.jalendar.WeekFields
import cn.soldat.jalendar.util.CalendarUtils
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Month(
    year: Int,
    month: Int = 0,
    day: Int = 1,
    indicatorDays: List<Int> = emptyList(),
    onClick: (year: Int, month: Int) -> Unit
) {
    val days = MonthFields.of(month).length(CalendarUtils.isLeapYear(year))
    val lastMonthDays =
        if (month == 0) MonthFields.of(11).length(CalendarUtils.isLeapYear(year - 1))
        else MonthFields.of(month - 1).length(CalendarUtils.isLeapYear(year))
    val calendar = Calendar.getInstance()
    val curYear = calendar.get(Calendar.YEAR)
    val curMonth = calendar.get(Calendar.MONTH)
    val curDay = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val prevDays = calendar.get(Calendar.DAY_OF_WEEK) - 1
    calendar.add(Calendar.DAY_OF_MONTH, -prevDays)
    val start = lastMonthDays - prevDays + 1 // 31 - 3 = 28  + 1 = 29
    LazyVerticalGrid(cells = GridCells.Fixed(7)) {
        items(7) { index ->
            Text(
                text = stringResource(id = WEEKS[WeekFields.values()[index]]!!),
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )
        }
        items(lastMonthDays - start + 1) { index ->
            DayOfMonth(day = index + start, currentMonth = false)
        }
        items(days) { index ->
            DayOfMonth(
                day = index + 1,
                selected = day == (index + 1),
                today = year == curYear && month == curMonth && curDay == (index + 1),
                indicator = indicatorDays.contains(index + 1),
                onClick = { onClick(month, it) }
            )
        }
        items(6 * 7 - prevDays - days) { index ->
            DayOfMonth(day = index + 1, currentMonth = false)
        }
    }
}

@Preview
@Composable
fun MonthPreview() {
    Month(year = 2022, month = 5, onClick = { _, _ -> })
}

