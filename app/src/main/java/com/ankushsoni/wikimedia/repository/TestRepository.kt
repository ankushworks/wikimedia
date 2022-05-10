package com.ankushsoni.wikimedia.repository

import androidx.room.withTransaction
import com.androiddevs.mvvmnewsapp.api.WikiApi
import com.ankushsoni.wikimedia.db.WikimediaDataBase
import com.ankushsoni.wikimedia.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class TestRepository  @Inject constructor(
    private val api : WikiApi,
    private val db : WikimediaDataBase )
{
    private val dao = db.wikimediaDao()

    fun getArticle() = networkBoundResource(
        query = {
            dao.getAllArticles()
        },
        fetch = {
            delay(2000)
            api.getRandomArticle()
        },
        saveFetchResult = {
            db.withTransaction {
                dao.deleteAllArticles()
                dao.insertArticles(it.body()?.query!!.pages)
            }
        }

    )


    fun getImages() = networkBoundResource(
        query = {
            dao.getAllImages()
        },
        fetch = {
            delay(2000)
            api.getFeaturedImages("query" )
        },
        saveFetchResult = {
            db.withTransaction {
                dao.deleteAllImages()
                dao.insertImages(it.body()?.query!!.pages)
            }
        }
    )

    fun getCategories() = networkBoundResource(
        query = {
            dao.getAllCategories()
        },
        fetch = {
            delay(2000)
            api.getCategories()
        },
        saveFetchResult = {
            db.withTransaction {
                dao.deleteAllCategories()
                dao.insertCategories(it.body()?.query!!.allcategories)
            }
        }
    )

}