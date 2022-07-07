package cn.soldat.jalendar.animated.components

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import cn.soldat.jalendar.WEEKS
import cn.soldat.jalendar.WeekFields
import cn.soldat.jalendar.animated.JalendarState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import java.time.LocalDate
import java.util.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AnimatedJalendar(
    state: JalendarState = remember { JalendarState(initialDate = LocalDate.now()) },
    locale: Locale = Locale.getDefault()
) {

    Column {
        val pagerState =
            rememberPagerState(initialPage = (state.selected.year - state.years.first) * 12 + state.selected.monthValue - 1)
        // Calendar Header
        JalendarHeaderView(state)
        // Week 星期
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            for (index in 0..6) {
                Text(
                    text = stringResource(id = WEEKS[WeekFields.values()[index]]!!),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        HorizontalPager(
            count = (state.years.last - state.years.first + 1) * 12,
            state = pagerState,
            userScrollEnabled = !state.showYearPicker
        ) { page ->
            // 计算出当前Page显示的年月1日
            val date = remember {
                LocalDate.of(state.years.first + page / 12, page % 12 + 1, 1)
            }
            if (currentPage == page) {
                state.selected = date.withDayOfMonth(
                    if (date.month.length(state.selected.isLeapYear)
                        >= state.selected.dayOfMonth
                    )
                        state.selected.dayOfMonth else 1
                )
            }

            Column {
                // 年份选择
                Box(modifier = Modifier.height(260.dp)) {
                    // 日历表格
                    androidx.compose.animation.AnimatedVisibility(
                        visible = state.showYearPicker,
                        modifier = Modifier
                            .zIndex(.5f)
                            .clipToBounds(),
                        enter = slideInVertically(initialOffsetY = { -it }),
                        exit = slideOutVertically(targetOffsetY = { -it })
                    ) {
                        YearPickerView(date, state, pagerState)
                    }
                    MonthView(date, state, locale)
                }
            }
        }
    }
}

