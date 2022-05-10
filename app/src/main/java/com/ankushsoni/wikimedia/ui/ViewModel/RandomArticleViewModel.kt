package com.ankushsoni.wikimedia.ui.ViewModel

import android.util.Log


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ankushsoni.wikimedia.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RandomArticleViewModel @Inject constructor(
    repository: TestRepository
) : ViewModel() {

    val article = repository.getArticle().asLiveData()
}