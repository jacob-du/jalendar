package cn.soldat.jalendar.util

import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

/**
 * @Author: Jacob Du
 * @Date: 2022/6/25 13:38
 * @Desc:
 * @Website: https://www.soldat.cn
 */

object CalendarUtils {
    /**
     * 求某年是不是闰年
     */
    fun isLeapYear(year: Int): Boolean = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
}

fun getDates(date: LocalDate, locale: Locale): Pair<Int, Int> {
    // 本月一共有几天
    val days = date.month.length(date.isLeapYear)
    // 本地 开始星期
    val firstDayOfWeek = WeekFields.of(locale).firstDayOfWeek.value
    // 第一天是星期几
    val firstDay = date.withDayOfMonth(1).dayOfWeek.value - firstDayOfWeek % 7

    return Pair(firstDay, days)
}
