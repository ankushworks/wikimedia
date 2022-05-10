package com.ankushsoni.wikimedia.models.RandomArticle


import com.google.gson.annotations.SerializedName

data class Limits(
    @SerializedName("extracts")
    val extracts: Int
)