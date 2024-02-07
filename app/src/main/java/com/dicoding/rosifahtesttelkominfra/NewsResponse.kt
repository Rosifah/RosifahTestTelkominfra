package com.dicoding.rosifahtesttelkominfra

data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
    )

data class Article(
    val title: String?,
    val description: String?,
    val url: String?
)
