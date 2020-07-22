package com.fazal.mviarchitecturedaggerhilt.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Blog Database Abstract Class
 */
@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class BlogDatabase: RoomDatabase() {

    abstract fun blogDao() : BlogDao

    companion object {
        val DATABASE_NAME = "blog_db"
    }
}