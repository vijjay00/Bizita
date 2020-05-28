@file:Suppress("DEPRECATION")

package com.newsfeed.utils

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import com.bizita.R
import java.util.*

fun toast(message : String,mContext : Context){
    Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
}

fun isNetworkAvailable(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo: NetworkInfo?
    activeNetworkInfo = cm.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
}
