package com.ankushsoni.wikimedia.models.Category


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("allcategories")
    val allcategories: List<Allcategories>
)