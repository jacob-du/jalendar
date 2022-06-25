package cn.soldat.jalendar

/**
 * @Author: Jacob Du
 * @Date: 2022/6/23 09:59
 * @Desc:
 * @Website: https://www.soldat.cn
 */

enum class MonthFields {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

    companion object {
        private val enums = values()
        fun of(month: Int): MonthFields {
            if (month < 0 || month > 11) {
                throw RuntimeException("Invalid value for MonthOfYear: $month")
            }
            return enums[month]
        }
    }

    fun maxLength(): Int {
        return when (this) {
            FEBRUARY -> 29
            APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
            else -> 31
        }
    }

    fun minLength(): Int {
        return when (this) {
            FEBRUARY -> 28
            APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
            else -> 31
        }
    }

    fun length(leapYear: Boolean): Int {
        return when (this) {
            FEBRUARY -> if (leapYear) 29 else 28
            APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
            else -> 31

        }
    }

}