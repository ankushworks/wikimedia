package com.ankushsoni.wikimedia.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.util.Resource
import com.ankushsoni.wikimedia.Adapter.ArticleAdapter
import com.ankushsoni.wikimedia.Adapter.CategoryAdapter
import com.ankushsoni.wikimedia.Adapter.TestCategoryAdapter
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.databinding.FragmentArticleBinding
import com.ankushsoni.wikimedia.databinding.FragmentCategoryBinding
import com.ankushsoni.wikimedia.ui.ViewModel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category) {

    val TAG = "CATEGORYFRAGMENT"
    private var binding: FragmentCategoryBinding? = null
    private val categoryViewModel : CategoryViewModel by viewModels()
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var testCategoryAdapter: TestCategoryAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)
        testCategoryAdapter = TestCategoryAdapter()



        categoryViewModel.category.observe(viewLifecycleOwner){ response ->
            testCategoryAdapter.submitList(response.data)
            binding!!.progressBar.isVisible = response is Resource.Loading && response.data.isNullOrEmpty()
            binding!!.textViewError.isVisible = response is Resource.Error && response.data.isNullOrEmpty()
            binding!!.textViewError.text =  "Please check your connection"
        }

        setupRecyclerView()

    }



    private fun setupRecyclerView(){
        binding?.rvCategory?.apply {
            adapter = testCategoryAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }



    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}