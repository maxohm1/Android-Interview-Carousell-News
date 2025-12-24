package com.thecarousell.carousell_news

import com.thecarousell.carousell_news.utils.TimeUtilImpl
import io.mockk.mockk
import org.junit.Test

class TimeUtilTest {

    // Wed Aug 11 16:28:28 SGT 2021
    private val compareTimestamp: Long = 1628670508000L
    private val timeUtil = TimeUtilImpl(mockk(relaxed = true))

    @Test
    fun test_getTimeAgoData_oneYear() {
        // Tue Aug 11 15:49:43 SGT 2020
        val timeMs = 1597132183000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.year_ago, 1))
    }

    @Test
    fun test_getTimeAgoData_twoYearsAgo() {
        // Sun Aug 11 15:49:43 SGT 2019
        val timeMs = 1565509783000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.year_ago, 2))
    }

    @Test
    fun test_getTimeAgoData_oneMonthAgo() {
        // Sun Jul 11 16:00:42 SGT 2021
        val timeMs = 1625990442000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.month_ago, 1))
    }

    @Test
    fun test_getTimeAgoData_twoMonthsAgo() {
        // Fri Jun 11 16:00:42 SGT 2021
        val timeMs = 1623398442000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.month_ago, 2))
    }

    @Test
    fun test_getTimeAgoData_oneWeekAgo() {
        // Tue Aug 03 16:20:14 SGT 2021
        val timeMs = 1627978814000
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.week_ago, 1))
    }

    @Test
    fun test_getTimeAgoData_twoWeeksAgo() {
        // Tue Jul 27 16:20:14 SGT 2021
        val timeMs = 1627374014000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.week_ago, 2))
    }

    @Test
    fun test_getTimeAgoData_oneDayAgo() {
        // Tue Aug 10 16:05:06 SGT 2021
        val timeMs = 1628582706000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.day_ago, 1))
    }

    @Test
    fun test_getTimeAgoData_twoDaysAgo() {
        // Mon Aug 09 16:05:06 SGT 2021
        val timeMs = 1628496306000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.plurals.day_ago, 2))
    }

    @Test
    fun test_getTimeAgoData_today() {
        // Wed Aug 11 16:26:44 SGT 2021
        val timeMs = 1628670404000L
        assert(timeUtil.getTimeAgoData(timeMs, compareTimestamp) == Pair(R.string.today, 0))
    }
}