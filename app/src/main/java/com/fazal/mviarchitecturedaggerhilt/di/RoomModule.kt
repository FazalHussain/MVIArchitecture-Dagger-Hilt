package com.fazal.mviarchitecturedaggerhilt.di

import android.content.Context
import androidx.room.Room
import com.fazal.mviarchitecturedaggerhilt.retrofit.BlogRetrofit
import com.fazal.mviarchitecturedaggerhilt.room.BlogDao
import com.fazal.mviarchitecturedaggerhilt.room.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Room Module to provide room dependencies and install in  [ApplicationComponent]
 */
@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDatabase(@ApplicationContext context: Context) : BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDao(blogDatabase: BlogDatabase) : BlogDao {
        return blogDatabase.blogDao()
    }
}