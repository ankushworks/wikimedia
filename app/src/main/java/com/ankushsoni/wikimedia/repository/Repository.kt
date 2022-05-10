package com.ankushsoni.wikimedia.repository


import com.ankushsoni.wikimedia.api.RetrofitInstance



class Repository() {


    suspend fun getFeaturedImages(action : String ) =
        RetrofitInstance.api.getFeaturedImages("query" )


    suspend fun getRandomArticle(action : String) =
        RetrofitInstance.api.getRandomArticle()

}