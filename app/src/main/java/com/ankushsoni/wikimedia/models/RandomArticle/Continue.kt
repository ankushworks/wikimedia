package com.ankushsoni.wikimedia.models.RandomArticle


import com.google.gson.annotations.SerializedName

data class Continue(
    @SerializedName("continue")
    val continueX: String,
    @SerializedName("grncontinue")
    val grncontinue: String
)