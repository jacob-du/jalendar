package cn.soldat.jalendar.animated.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.soldat.jalendar.animated.JalendarState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun YearPickerView(
    date: LocalDate,
    state: JalendarState,
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()
    val gridState = rememberLazyGridState((date.year - state.years.first) / 4)
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        state = gridState,
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        items(state.years.toList()) { year ->
            val selected = remember { year == date.year }
            YearPickerItemView(year = year, selected = selected) {
                if (!selected) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(
                            pagerState.currentPage + (year - date.year) * 12
                        )
                        state.selected = LocalDate.of(
                            year, state.selected.monthValue, state.selected.dayOfMonth
                        )
                    }
                }
                state.showYearPicker = false
            }
        }
    }
}

@Composable
internal fun YearPickerItemView(year: Int, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (selected) MaterialTheme.colors.primary else Color.Transparent)
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = year.toString(),
            fontSize = 14.sp,
            color = if (selected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground
        )
    }
}
