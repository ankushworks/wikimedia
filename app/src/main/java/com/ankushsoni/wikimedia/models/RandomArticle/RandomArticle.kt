package com.ankushsoni.wikimedia.models.RandomArticle


import com.google.gson.annotations.SerializedName

data class RandomArticle(
    @SerializedName("batchcomplete")
    val batchcomplete: Boolean,
    @SerializedName("continue")
    val continueX: Continue,
    @SerializedName("limits")
    val limits: Limits,
    @SerializedName("query")
    val query: Query
)