package com.ankushsoni.wikimedia.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.util.Resource
import com.ankushsoni.wikimedia.Adapter.TestImageAdapter
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.WebActivity
import com.ankushsoni.wikimedia.databinding.FragmentImageBinding
import com.ankushsoni.wikimedia.ui.ViewModel.FeaturedImagesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImagesFragment : Fragment(R.layout.fragment_image) {

    private var binding: FragmentImageBinding? = null
    private val featuredImagesViewModel : FeaturedImagesViewModel by viewModels()
    lateinit var testImageAdapter: TestImageAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentImageBinding.bind(view)
        testImageAdapter = TestImageAdapter()

        setupRecyclerView()



        testImageAdapter.setonClickListener {
            val intent = Intent(activity, WebActivity::class.java)
            intent.putExtra("URL" , it.imageinfo.map { it.descriptionshorturl }[0])
            startActivity(intent)
        }


        featuredImagesViewModel.images.observe(viewLifecycleOwner){ response ->
            testImageAdapter.submitList(response.data)
            binding!!.imageProgressBar.isVisible = response is Resource.Loading && response.data.isNullOrEmpty()
            binding!!.imageTextViewError.isVisible = response is Resource.Error && response.data.isNullOrEmpty()
            binding!!.imageTextViewError.text =  "Please check your connection"
        }


    }


    private fun setupRecyclerView(){
        binding?.rvFeaturedImage?.apply {
            adapter = testImageAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }



    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}