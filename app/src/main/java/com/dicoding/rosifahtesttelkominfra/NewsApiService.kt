package com.dicoding.rosifahtesttelkominfra

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    fun getTopHeadline(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey:String
    ): Call<NewsResponse>
}