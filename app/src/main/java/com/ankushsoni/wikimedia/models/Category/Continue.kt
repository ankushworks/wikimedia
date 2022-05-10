package com.ankushsoni.wikimedia.models.Category


import com.google.gson.annotations.SerializedName

data class Continue(
    @SerializedName("accontinue")
    val accontinue: String,
    @SerializedName("continue")
    val continueX: String
)