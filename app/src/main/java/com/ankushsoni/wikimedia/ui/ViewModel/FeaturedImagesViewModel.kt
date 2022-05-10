package com.ankushsoni.wikimedia.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.util.Resource
import com.ankushsoni.wikimedia.models.featuredImages.FeatureImages
import com.ankushsoni.wikimedia.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import android.util.Log
import androidx.lifecycle.asLiveData
import com.ankushsoni.wikimedia.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeaturedImagesViewModel @Inject constructor(
    repository: TestRepository
) : ViewModel() {
    val images = repository.getImages().asLiveData()

}