package com.fazal.mviarchitecturedaggerhilt.retrofit

import com.fazal.mviarchitecturedaggerhilt.model.Blog
import retrofit2.http.GET

/**
 * Blog Retrofit Interface definition for retrofit endpoints
 */
interface BlogRetrofit {

    @GET("blogs")
    suspend fun get() : List<BlogNetworkEntity>

}