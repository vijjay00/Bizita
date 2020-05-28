package com.bizita.repository

import com.bizita.data.HomeData
import com.newsfeed.utils.MyApi
import retrofit2.Call

class HomeRepository {
    fun getDetails() : Call<HomeData> {
        return MyApi().fetchdetails()
    }
}