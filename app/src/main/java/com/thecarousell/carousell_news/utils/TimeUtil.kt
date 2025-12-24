package com.thecarousell.carousell_news.utils

import androidx.annotation.VisibleForTesting
import com.thecarousell.carousell_news.R

interface TimeUtil {
    fun getTimeAgoString(timeMs: Long): String
}

class TimeUtilImpl(private val resourcesManager: ResourcesManager) : TimeUtil {
    /**
     * Calculate the time difference between today and [timeMs],
     * and return a readable string. Here are some example of the format:
     *
     * Difference < 1 day > "Today"
     *
     * 5 days ago > “5 days ago”
     * 7 days ago > “1 week ago”
     * 4 weeks ago > “1 month ago”
     * 12 months ago > “1 year ago”
     */
    override fun getTimeAgoString(timeMs: Long): String {
        // Fill in get time ago logic, and return correct string representation
        val (res, quantity) = getTimeAgoData(timeMs)
        if (quantity == 0) return resourcesManager.getString(res)
        return resourcesManager.getQuantityString(res, quantity)
    }

    @VisibleForTesting
    fun getTimeAgoData(
        timeMs: Long,
        compareTimestamp: Long = System.currentTimeMillis()
    ): Pair<Int, Int> {
        return Pair(R.string.today, 0)
    }
}