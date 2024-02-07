package com.dicoding.rosifahtesttelkominfra

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private var article: List<Article>): RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsAdapter.ArticleViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ArticleViewHolder, position: Int) {
      val article = article[position]
        holder.title.text = article.title
        holder.description.text = article.description
        holder.url.text = article.url
    }

    override fun getItemCount(): Int  = article.size


    class ArticleViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.articleTitle)
        val description: TextView = view.findViewById(R.id.articleDescription)
        val url : TextView = view.findViewById(R.id.articleSource)
    }

    fun updateData(newArticle: List<Article>){
        article = newArticle
        notifyDataSetChanged()
    }
}