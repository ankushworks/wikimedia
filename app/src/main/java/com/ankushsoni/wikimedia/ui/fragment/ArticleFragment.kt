package com.ankushsoni.wikimedia.ui.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.util.Resource
import com.ankushsoni.wikimedia.Adapter.ArticleAdapter
import com.ankushsoni.wikimedia.Adapter.TestArticleAdapter
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.databinding.FragmentArticleBinding
import com.ankushsoni.wikimedia.ui.ViewModel.RandomArticleViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticleFragment : Fragment(R.layout.fragment_article) {

    val TAG = "IMAGEFRAGMENT"
    private var binding: FragmentArticleBinding? = null
    private val randomArticleViewModel : RandomArticleViewModel by viewModels()
    lateinit var articleAdapter: ArticleAdapter
    lateinit var testArticleAdapter: TestArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testArticleAdapter = TestArticleAdapter()


        binding = FragmentArticleBinding.bind(view)
        randomArticleViewModel.article.observe(viewLifecycleOwner){ response ->
            testArticleAdapter.submitList(response.data)
            binding!!.progressBar.isVisible = response is Resource.Loading && response.data.isNullOrEmpty()
            binding!!.textViewError.isVisible = response is Resource.Error && response.data.isNullOrEmpty()
            binding!!.textViewError.text =  "Please check your connection"
        }

        setupRecyclerView()
    }


    private fun setupRecyclerView(){
        binding?.rvArticle?.apply {
            adapter = testArticleAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}