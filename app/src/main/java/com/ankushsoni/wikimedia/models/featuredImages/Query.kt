package com.ankushsoni.wikimedia.models.featuredImages


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("pages")
    val pages: List<Page>
)