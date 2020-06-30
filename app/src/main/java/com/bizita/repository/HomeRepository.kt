package com.bizita.repository

import com.bizita.data.Succes
import com.bizita.ui.HomeActivity
import com.bizita.utils.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeRepository {

    fun getDetails(homeActivity: HomeActivity) {
        GlobalScope.launch(Dispatchers.IO){
            val  response = MyApi().fetchdetails()
            try {
                if(response.isSuccessful){
                    response.body()?.Success?.let { homeActivity.onSucess(it as ArrayList<Succes>) }
                }else{
                    homeActivity.onError(response.errorBody().toString())
                }
            }catch (e : Exception){
                homeActivity.onError(e.message.toString())
            }

        }
    }
}