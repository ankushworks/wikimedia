package com.ankushsoni.wikimedia.models.featuredImages


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Images")
data class Page(
    @SerializedName("imageinfo")
    val imageinfo: List<Imageinfo>,
    @SerializedName("imagerepository")
    val imagerepository: String,
    @SerializedName("ns")
    val ns: Int,
    @SerializedName("pageid")
    @PrimaryKey val pageid: Int,
    @SerializedName("title")
    val title: String
)