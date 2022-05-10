package com.ankushsoni.wikimedia.models.Category


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Allcategories")
data class Allcategories(
    @SerializedName("category")
    val category: String,
    @PrimaryKey(autoGenerate = true)
    val id : Int
)