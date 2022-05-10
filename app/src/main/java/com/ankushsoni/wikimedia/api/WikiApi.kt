package com.androiddevs.mvvmnewsapp.api


import com.ankushsoni.wikimedia.models.Category.Allcategories
import com.ankushsoni.wikimedia.models.Category.Categories
import com.ankushsoni.wikimedia.models.RandomArticle.RandomArticle
import com.ankushsoni.wikimedia.models.featuredImages.FeatureImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.ankushsoni.wikimedia.util.Constants.Companion.FORMAT
import com.ankushsoni.wikimedia.util.Constants.Companion.FORMAT_VERSION
import com.ankushsoni.wikimedia.util.Constants.Companion.GCMTITLE
import com.ankushsoni.wikimedia.util.Constants.Companion.GCMTYPE
import com.ankushsoni.wikimedia.util.Constants.Companion.GENERATOR
import com.ankushsoni.wikimedia.util.Constants.Companion.IIPROP
import com.ankushsoni.wikimedia.util.Constants.Companion.PROP
import retrofit2.http.Url


interface WikiApi {

    @GET("api.php")
    suspend fun getFeaturedImages(
                      @Query("action") action: String,
                      @Query("prop") prop: String   = PROP,
                      @Query("iiprop") iiprop: String = IIPROP,
                      @Query("generator") generator: String = GENERATOR,
                      @Query("gcmtype") gcmtype: String = GCMTYPE,
                      @Query("gcmtitle") gcmtitle: String = GCMTITLE,
                      @Query("format") format: String = FORMAT,
                      @Query("formatversion") formatVersion : Int = FORMAT_VERSION
    ): Response<FeatureImages>




//      https: en.wikipedia.org/w/api.php? format=json
//      &action=query
//      &generator=random
//      &grnnamespace=0
//      &prop=revisions%7Cimages
//      &rvprop=content
//      &grnlimit=10
//      &formatversion=2


//     https://en.wikipedia.org/w/api.php?format=json&
//     action=query
//     &generator=random
//     &grnnamespace=0
//     &prop=extracts
//     &exlimit=max
//     &explaintext
//     &exintro
//     &grnlimit=10
//     &formatversion=2



//    @GET("api.php")
//    suspend fun getRandomArticle(
//        @Query("format") format: String = FORMAT,
//        @Query("action") action: String,
//        @Query("generator") generator: String = "random",
//        @Query("grnnamespace") grnnamespace: Int = 0,
//        @Query("prop") prop: String   = "extracts",
//        @Query("exlimit") exLimit: String   = "max",
//        @QueryName explainText: String? ="explaintext",
//        @QueryName exinTro: String? = "exintro",
//        @Query("grnlimit") grnlimit: Int = 10,
//        @Query("formatversion") formatVersion : Int = FORMAT_VERSION
//    ) : Response<RandomArticle>


    @GET()
    suspend fun getRandomArticle(
        @Url url : String  = "https://en.wikipedia.org/w/api.php?format=json&action=query&generator=random&grnnamespace=0&prop=extracts&exlimit=max&explaintext&exintro&grnlimit=10&formatversion=2"
    ) : Response<RandomArticle>


    @GET()
    suspend fun getCategories(
        @Url url : String = "https://en.wikipedia.org/w/api.php?action=query&list=allcategories&acprefix=List+of&formatversion=2&format=json"
    )  : Response<Categories>

}