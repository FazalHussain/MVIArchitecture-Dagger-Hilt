package com.fazal.mviarchitecturedaggerhilt.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Blog Data Access Objects where you define your blog database interactions.
 * They can include a variety of query methods.
 */
@Dao
interface BlogDao {

    /**
     * Insert the data on Blog table however if data present replace the data
     *
     * @return The row Id that tells that data is inserted on the row
     * however, If error occur it would return -1
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogCacheEntity: BlogCacheEntity) : Long

    @Query("SELECT * FROM blogs")
    suspend fun get() : List<BlogCacheEntity>
}