package com.dicoding.rosifahtesttelkominfra

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https:/newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val newsApi = retrofit.create(NewsApiService::class.java)

    fun getTopHeadlines(country: String, category: String, apiKey: String): LiveData<List<Article>>{
        val data = MutableLiveData<List<Article>>()
        newsApi.getTopHeadline(country, category, apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                when(response.code()){
                    200 -> data.value = response.body()?.articles
                    500 -> Log.e("ERROR", "INTERNAL SERVER ERROR")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                t.localizedMessage?.let { Log.d("LOGGER_FAILURE", it) }
            }

        })
        return data
    }

}