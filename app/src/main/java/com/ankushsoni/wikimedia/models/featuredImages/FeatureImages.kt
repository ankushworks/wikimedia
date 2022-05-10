package com.ankushsoni.wikimedia.models.featuredImages


import com.google.gson.annotations.SerializedName

data class FeatureImages(
    @SerializedName("batchcomplete")
    val batchcomplete: Boolean,
    @SerializedName("continue")
    val continueX: Continue,
    @SerializedName("query")
    val query: Query
)