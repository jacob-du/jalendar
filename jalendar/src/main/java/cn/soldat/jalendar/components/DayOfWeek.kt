package cn.soldat.jalendar.components

/**
 * @Author: Jacob Du
 * @Date: 2022/6/22 16:51
 * @Desc:
 * @Website: https://www.soldat.cn
 */


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.soldat.jalendar.WEEKS
import cn.soldat.jalendar.WeekFields

@Composable
fun Day(
    selected: Boolean = false,
    week: WeekFields = WeekFields.SUN,
    day: Int = 1,
    indicator: Boolean = false,
    indicatorColor: Color = MaterialTheme.colors.primary,
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = if (selected) MaterialTheme.colors.primary else Color.LightGray,
        contentColor = if (selected) MaterialTheme.colors.onPrimary else Color.Black
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (week == WeekFields.SAT || week == WeekFields.SUN) {
                Text(
                    text = stringResource(id = WEEKS[week]!!),
                    color = Color.Red, fontSize = 14.sp
                )
            } else {
                Text(text = stringResource(id = WEEKS[week]!!), fontSize = 14.sp)
            }
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
        }
    }
}

@Preview
@Composable
fun DayPreview() {
    Day()
}

