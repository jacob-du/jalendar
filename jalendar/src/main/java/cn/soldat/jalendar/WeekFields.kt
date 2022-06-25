package cn.soldat.jalendar

/**
 * @Author: Jacob Du
 * @Date: 2022/6/22 16:53
 * @Desc:
 * @Website: https://www.soldat.cn
 */

enum class WeekFields {
    SUN, MON, TUE, WED, THU, FRI, SAT
}

val WEEKS = mapOf(
    WeekFields.SUN to R.string.sun,
    WeekFields.MON to R.string.mon,
    WeekFields.TUE to R.string.tue,
    WeekFields.WED to R.string.wed,
    WeekFields.THU to R.string.thu,
    WeekFields.FRI to R.string.fri,
    WeekFields.SAT to R.string.sat
)