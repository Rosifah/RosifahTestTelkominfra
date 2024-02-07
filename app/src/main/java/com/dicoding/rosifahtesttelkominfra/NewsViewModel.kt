package com.dicoding.rosifahtesttelkominfra

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NewsViewModel: ViewModel() {
    private val newsRepository = NewsRepository()

    fun getTopHeadlines(country: String, category: String, apiKey: String): LiveData<List<Article>>{
        return newsRepository.getTopHeadlines(country, category, apiKey)
    }

}