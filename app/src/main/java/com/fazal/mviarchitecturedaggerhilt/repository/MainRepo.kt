package com.fazal.mviarchitecturedaggerhilt.repository

import com.fazal.mviarchitecturedaggerhilt.model.Blog
import com.fazal.mviarchitecturedaggerhilt.retrofit.BlogNetworkEntity
import com.fazal.mviarchitecturedaggerhilt.retrofit.BlogRetrofit
import com.fazal.mviarchitecturedaggerhilt.retrofit.NetworkMapper
import com.fazal.mviarchitecturedaggerhilt.room.BlogDao
import com.fazal.mviarchitecturedaggerhilt.room.CacheMapper
import com.fazal.mviarchitecturedaggerhilt.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepo
@Inject constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    /**
     * Flow provide the non-blocking stream of data and it written over kotlin coroutine
     *
     * Fetch the blogs using flow builder and emit the different [DataState]
     *
     * 1. Fetch Data From Network
     * 2. Map The [List][BlogNetworkEntity] to [List][Blog]
     * 3. Insert each blog into room cache
     * 4. Fetch the data from cache
     * 5. emit the data
     */
    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        // Emit loading state
        emit(DataState.Loading)
        delay(1000) // Don't do in production just for testing
        try {
            // Fetch data from network
            val networkBlogs = blogRetrofit.get()
            // Map collection of BlogNetworkEntity to Blog
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs) {
                // Map to BlogCacheEntity and insert into cache
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            // Fetch From the cache
            val cacheBlogs = blogDao.get()
            // Emit Success with the collection of Blog
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheBlogs)))
        } catch (e: Exception) {
            // Emit the error
            emit(DataState.Error(e))
        }
    }
}