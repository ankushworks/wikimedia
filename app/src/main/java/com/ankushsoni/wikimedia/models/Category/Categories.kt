package com.ankushsoni.wikimedia.models.Category


import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("batchcomplete")
    val batchcomplete: Boolean,
    @SerializedName("continue")
    val continueX: Continue,
    @SerializedName("query")
    val query: Query
)