package com.ankushsoni.wikimedia.ui.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ankushsoni.wikimedia.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    repository: TestRepository
) : ViewModel() {

    val category = repository.getCategories().asLiveData()

    init {
        Log.d("TestImageView" , category.value.toString() )
    }

}