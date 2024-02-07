package com.dicoding.rosifahtesttelkominfra
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.rosifahtesttelkominfra.NewsAdapter
import com.dicoding.rosifahtesttelkominfra.NewsViewModel
import com.dicoding.rosifahtesttelkominfra.ProfileActivity
import com.dicoding.rosifahtesttelkominfra.R

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)


        initAdapter()

        viewModel.getTopHeadlines("us", "business", "036071743c234a45bc8f2b53088149be")
            .observe(this, Observer { article ->
                newsAdapter.updateData(article ?: emptyList())
            })

        // Mendapatkan tombol kembali dan menambahkan fungsi onClick
        val backButton = findViewById<Button>(R.id.profile)
        backButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk kembali ke halaman utama
    fun backToMain(view: View) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    fun initAdapter() {
        recyclerView = findViewById(R.id.layoutnews)
        newsAdapter = NewsAdapter(emptyList())
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
