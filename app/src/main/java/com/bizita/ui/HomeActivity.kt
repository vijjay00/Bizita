@file:Suppress("DEPRECATION")

package com.bizita.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bizita.R
import com.bizita.data.Succes
import com.bizita.databinding.ActivityHomeBinding
import com.bizita.ui.adapter.HomeAdapter
import com.bizita.viewmodel.HomeVM
import com.newsfeed.utils.isNetworkAvailable
import com.newsfeed.utils.toast
import kotlinx.android.synthetic.main.activity_home.*

abstract class HomeActivity : AppCompatActivity(),HomeVM.HomeAuthlistner {

    abstract var viewModle : HomeVM
    private lateinit var linear : LinearLayoutManager
    private  lateinit var listAdapter:HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeBinding = DataBindingUtil.setContentView<ActivityHomeBinding>(this,R.layout.activity_home)
        viewModle = ViewModelProviders.of(this).get(HomeVM::class.java)
        activityHomeBinding.model = viewModle
        setAdapter()
        viewModle.onRetryApi(this)
        
    }

    private fun setAdapter() {
        linear = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linear
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                outRect.left =  applicationContext!!.resources.getDimension(R.dimen.margin_3dp).toInt()
                outRect.right =  applicationContext!!.resources.getDimension(R.dimen.margin_3dp).toInt()
            }
        })
        listAdapter =   HomeAdapter(applicationContext)
        recyclerView.adapter = listAdapter
    }

    override fun onSucess(detailsList: ArrayList<Succes>) {
        viewModle.onProgressVisible()
        listAdapter.setAdapterList(detailsList)
    }

    override fun onRetry(message: String) {
        viewModle.onProgressVisible()
        viewModle.onRetry()
        toast(message,applicationContext)
    }

    override fun onError(message: String) {
        viewModle.onProgressVisible()
       toast(message,applicationContext)
    }
}
