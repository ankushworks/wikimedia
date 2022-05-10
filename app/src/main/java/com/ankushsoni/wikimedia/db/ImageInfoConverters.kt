package com.ankushsoni.wikimedia.db

import androidx.room.TypeConverter
import com.ankushsoni.wikimedia.models.featuredImages.Imageinfo
import com.google.gson.Gson


class ImageInfoConverters {

    @TypeConverter
    fun listToJson(value : List<Imageinfo>? ) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value : String) = Gson().fromJson(value,Array<Imageinfo>::class.java).toList()
}