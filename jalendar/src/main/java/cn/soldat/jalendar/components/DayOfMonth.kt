package cn.soldat.jalendar.components

/**
 * @Author: Jacob Du
 * @Date: 2022/6/23 09:58
 * @Desc:
 * @Website: https://www.soldat.cn
 */


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DayOfMonth(
    selected: Boolean = false,
    day: Int = 1,
    today: Boolean = false,
    indicator: Boolean = false,
    indicatorColor: Color = MaterialTheme.colors.primary,
    currentMonth: Boolean = true,
    onClick: (Int) -> Unit = {}
) {
    Surface(
        color = Color.Transparent,
        contentColor = if (!currentMonth) Color.LightGray else if (selected) MaterialTheme.colors.onPrimary
        else if (today) MaterialTheme.colors.secondary else Color.Black
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.background)
                .clickable { onClick(day) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = day.toString(), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Box(modifier = Modifier.size(6.dp), contentAlignment = Alignment.Center) {
                val selectedIndicatorColor = MaterialTheme.colors.onPrimary
                if (indicator) {
                    Canvas(modifier = Modifier.size(4.dp)) {
                        drawCircle(color = if (selected) selectedIndicatorColor else indicatorColor)
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun DayOfMonthPreview() {
    DayOfMonth()
}

