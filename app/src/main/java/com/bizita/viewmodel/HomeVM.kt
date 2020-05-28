package com.bizita.viewmodel

import androidx.lifecycle.ViewModel
import com.bizita.data.HomeData
import com.bizita.data.Succes
import com.bizita.repository.HomeRepository
import com.bizita.ui.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeVM : ViewModel() {

    fun getload(homeActivity: HomeActivity) {
        HomeRepository().getDetails().enqueue(object :
            Callback<HomeData> {
            override fun onFailure(call: Call<HomeData>, t: Throwable) {
                homeActivity.onError(t.message.toString())
            }

            override fun onResponse(call: Call<HomeData>, response: Response<HomeData>) {
                if(response.isSuccessful){
                    response.body()?.Success?.let { homeActivity.onSucess(it as ArrayList<Succes>) }
                }else{
                    homeActivity.onError(response.errorBody().toString())
                }
            }
        })
    }

    interface HomeAuthlistner {
        fun onSucess(detailsList: ArrayList<Succes>);
        fun onError(message : String);
    }
}
