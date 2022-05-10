package com.ankushsoni.wikimedia.models.featuredImages


import com.google.gson.annotations.SerializedName

data class Imageinfo(
    @SerializedName("descriptionshorturl")
    val descriptionshorturl: String,
    @SerializedName("descriptionurl")
    val descriptionurl: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: String
)