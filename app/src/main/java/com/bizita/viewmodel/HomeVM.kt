package com.bizita.viewmodel

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bizita.data.Succes
import com.bizita.repository.HomeRepository
import com.bizita.ui.HomeActivity
import com.newsfeed.utils.isNetworkAvailable


class HomeVM() : ViewModel() {

    val progress_bar = MutableLiveData<Int>()
    val retry = MutableLiveData<Int>()

    fun getload(homeActivity: HomeActivity) {
        HomeRepository().getDetails(homeActivity)
    }

    fun onProgressVisible(){
              if(progress_bar.value == GONE)  VISIBLE  else GONE
    }
    fun onRetry(){
        if(retry.value == GONE)  VISIBLE  else GONE
    }

    fun onRetryApi( homeActivity: HomeActivity){
        if(isNetworkAvailable(homeActivity)) {
            onProgressVisible()
            getload(homeActivity)
        }else{
            onRetry()
            homeActivity.onError("No internet Connection")
        }
    }

    interface HomeAuthlistner {
        fun onSucess(detailsList: ArrayList<Succes>)
        fun onRetry(message : String)
        fun onError(message : String)
    }
}
