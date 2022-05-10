package com.ankushsoni.wikimedia.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ankushsoni.wikimedia.models.Category.Allcategories
import com.ankushsoni.wikimedia.models.RandomArticle.Page
import com.ankushsoni.wikimedia.models.featuredImages.Page as Images


@Database(entities = [Page::class , Images::class , Allcategories::class], version = 1 , exportSchema = false)
@TypeConverters(ImageInfoConverters::class)
abstract class WikimediaDataBase : RoomDatabase() {
    abstract fun wikimediaDao(): WikimediaDao
}