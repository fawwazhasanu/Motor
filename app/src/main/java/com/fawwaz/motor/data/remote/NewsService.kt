package com.fawwaz.motor.data.remote

import com.fawwaz.motor.data.model.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET( "/native/motor")
    fun listNews() : Call<NewsList>

    @GET("detail/")
    fun detailNews(@Query( "url") url: String) : Call<NewsList>

    @GET("search/")
    fun searchNews(@Query("q") query: String) : Call<NewsList>

}