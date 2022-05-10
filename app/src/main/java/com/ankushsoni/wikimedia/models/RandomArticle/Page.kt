package com.ankushsoni.wikimedia.models.RandomArticle


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "articles")
data class Page(
    @SerializedName("extract")
    val extract: String,
    @SerializedName("ns")
    val ns: Int,
    @SerializedName("pageid")
    @PrimaryKey val pageid: Int,
    @SerializedName("title")
    val title: String
)