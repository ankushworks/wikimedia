package com.ankushsoni.wikimedia.models.RandomArticle


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("pages")
    val pages: List<Page>
)