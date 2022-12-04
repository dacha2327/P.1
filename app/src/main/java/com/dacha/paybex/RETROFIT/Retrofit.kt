package com.dacha.paybex.RETROFIT

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object{
        var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
        var api = retrofit.create(PixaApi::class.java)

    }





}