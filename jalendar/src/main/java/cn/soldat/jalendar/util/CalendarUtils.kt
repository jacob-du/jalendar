package cn.soldat.jalendar.util

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