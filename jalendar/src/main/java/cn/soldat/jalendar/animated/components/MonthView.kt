package cn.soldat.jalendar.animated.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.soldat.jalendar.animated.JalendarState
import cn.soldat.jalendar.util.getDates
import java.time.LocalDate
import java.util.*

/**
 * 日历视图 只显示当月的天数
 */
@Composable
internal fun MonthView(
    date: LocalDate,
    state: JalendarState,
    locale: Locale
) {
    Column {

        val dates = remember { getDates(date, locale) }
        // 本月天数
        val dateList = remember { IntRange(1, dates.second).toList() }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .height(260.dp)
                .padding(top = 2.dp)
        ) {
            if (dates.first != 7) {
                items(IntRange(0, dates.first - 1).toList()) {
                    Box(modifier = Modifier.size(30.dp))
                }
            }
            items(dateList) { item ->
                val selected = remember(state.selected) {
                    item == state.selected.dayOfMonth
                }
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            if (selected) MaterialTheme.colors.primary
                            else MaterialTheme.colors.background
                        )
                        .clickable { state.selected = date.withDayOfMonth(item) }
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item.toString(),
                        fontSize = 14.sp,
                        color = if (selected) MaterialTheme.colors.onPrimary
                        else MaterialTheme.colors.onBackground
                    )
                }
            }
        }

    }
}