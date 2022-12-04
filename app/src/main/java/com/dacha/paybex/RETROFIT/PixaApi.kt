package com.dacha.paybex.RETROFIT

import com.dacha.paybex.PixaModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("/api/")
    fun getImage(
        @Query("q") keyWord: String,
        @Query("Key") key: String = "31548678-7d2dc4084b45f478593c6b6a3",
        @Query("page") page:Int,
        @Query("per_page") per_page:Int = 5
    ): Call<PixaModel>
}