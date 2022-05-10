package com.ankushsoni.wikimedia.models.featuredImages


import com.google.gson.annotations.SerializedName

data class Continue(
    @SerializedName("continue")
    val continueX: String,
    @SerializedName("gcmcontinue")
    val gcmcontinue: String
)