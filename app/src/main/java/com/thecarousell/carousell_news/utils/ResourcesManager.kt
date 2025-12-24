package com.thecarousell.carousell_news.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat

interface ResourcesManager {
    fun getString(@StringRes resId: Int): String

    fun getString(@StringRes resId: Int, vararg placeHolders: Any): String

    fun getQuantityString(@PluralsRes resId: Int, quantity: Int): String

    fun getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any): String

    fun getColor(@ColorRes resId: Int): Int

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    fun getDimensionPixelSize(@DimenRes redId: Int): Int

    fun getDensityDpi(): Int
}


class ResourcesManagerImpl(private val appContext: Context) : ResourcesManager {
    override fun getString(@StringRes resId: Int): String =
        if (resId == 0) "" else appContext.getString(resId)

    override fun getString(@StringRes resId: Int, vararg placeHolders: Any): String =
        if (resId == 0) "" else appContext.getString(resId, *placeHolders)

    override fun getQuantityString(@PluralsRes resId: Int, quantity: Int): String =
        if (resId == 0) "" else appContext.resources.getQuantityString(resId, quantity)

    override fun getQuantityString(
        @PluralsRes resId: Int,
        quantity: Int,
        vararg formatArgs: Any
    ): String =
        if (resId == 0) "" else appContext.resources.getQuantityString(resId, quantity, *formatArgs)

    override fun getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(appContext, resId)

    override fun getDrawable(@DrawableRes resId: Int): Drawable? =
        ContextCompat.getDrawable(appContext, resId)

    override fun getDimensionPixelSize(@DimenRes redId: Int): Int =
        appContext.resources.getDimensionPixelSize(redId)

    override fun getDensityDpi(): Int = appContext.resources.displayMetrics.densityDpi
}

