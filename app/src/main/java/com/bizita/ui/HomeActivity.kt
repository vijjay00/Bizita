@file:Suppress("DEPRECATION")

package com.bizita.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bizita.R
import com.bizita.data.Succes
import com.bizita.ui.adapter.HomeAdapter
import com.bizita.viewmodel.HomeVM
import com.newsfeed.utils.isNetworkAvailable
import com.newsfeed.utils.toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),HomeVM.HomeAuthlistner {

    private lateinit var viewModle : HomeVM
    private lateinit var linear : LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModle = ViewModelProviders.of(this).get(HomeVM::class.java)
        onRetry(retry)
    }

    fun onRetry(view: View?) {
        if(isNetworkAvailable(applicationContext)){
            viewModle.getload(this)
            progress_bar.visibility = View.VISIBLE
            view?.visibility = View.GONE
        }else{
            retry.visibility = View.VISIBLE
            toast("No Internet Connection",applicationContext)
        }
    }

    override fun onSucess(detailsList: ArrayList<Succes>) {
        linear = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linear
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                outRect.left =  applicationContext!!.resources.getDimension(R.dimen.margin_3dp).toInt()
                outRect.right =  applicationContext!!.resources.getDimension(R.dimen.margin_3dp).toInt()
            }
        })
        recyclerView.adapter = HomeAdapter(detailsList,applicationContext)
        progress_bar.visibility = View.GONE
    }

    override fun onError(message: String) {
       toast(message,applicationContext)
    }
}
