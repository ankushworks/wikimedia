package com.ankushsoni.wikimedia.db


import androidx.room.*
import com.ankushsoni.wikimedia.models.Category.Allcategories
import com.ankushsoni.wikimedia.models.RandomArticle.Page
import com.ankushsoni.wikimedia.models.featuredImages.Page as ImageInfo
import kotlinx.coroutines.flow.Flow


@Dao
interface WikimediaDao {

    @Query("SELECT * FROM articles")
    fun getAllArticles() : Flow<List<Page>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles( article : List<Page> )

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()


    //Images


    @Query("SELECT *  FROM Images")
    fun getAllImages() : Flow<List<ImageInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages( images : List<ImageInfo> )

    @Query("DELETE FROM Images")
    suspend fun deleteAllImages()


    // categories

    @Query("SELECT *  FROM Allcategories")
    fun getAllCategories() : Flow<List<Allcategories>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories( allcategories: List<Allcategories> )

    @Query("DELETE FROM allcategories")
    suspend fun deleteAllCategories()


}