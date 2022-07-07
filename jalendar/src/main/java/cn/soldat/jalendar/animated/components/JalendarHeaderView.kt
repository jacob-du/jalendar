package cn.soldat.jalendar.animated.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.soldat.jalendar.R
import cn.soldat.jalendar.animated.JalendarState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import java.util.*

@Composable
internal fun JalendarHeaderView(
    state: JalendarState,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        ) {

            TextButton(onClick = { state.showYearPicker = !state.showYearPicker },
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.onPrimary
            )) {
                Text(text = stringResource(id = R.string.year, state.selected.year))
                Icon(
                    imageVector = if (state.showYearPicker) Icons.Rounded.ArrowDropUp
                    else Icons.Rounded.ArrowDropDown, contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.month, state.selected.monthValue),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(
                    id = R.string.year_month_day,
                    state.selected.year,
                    state.selected.monthValue,
                    state.selected.dayOfMonth
                ),
                fontSize = 12.sp
            )
        }
    }


}
