package com.thecarousell.carousell_news.utils

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UtilModule {
    @Provides
    @Singleton
    fun provideResourcesManager(@ApplicationContext app: Context): ResourcesManager =
        ResourcesManagerImpl(app)

    @Provides
    @Singleton
    fun provideTimeUtil(resourcesManager: ResourcesManager): TimeUtil =
        TimeUtilImpl(resourcesManager)
}