package com.newsfeed.utils

import com.bizita.data.HomeData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface MyApi {

    @GET("tracking/viewreport.php")
    fun fetchdetails(): Call<HomeData>

    companion object{
        operator fun invoke(): MyApi {

            val okkHttpclient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://aryu.co.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}