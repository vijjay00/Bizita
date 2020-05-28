package com.bizita.ui.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bizita.R
import com.bizita.data.Succes
import com.bizita.ui.ProfileDetailsActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.newsfeed.utils.isNetworkAvailable
import com.newsfeed.utils.toast

class HomeAdapter  (var sources: ArrayList<Succes>, val mContext: Context) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_display, parent, false)
        return MyViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val datas = sources.get(position)

        holder.titleText.text = datas.name
        holder.category.text = datas.category
        holder.address.text = datas.address

        onImageRetry(datas.image,holder.progress_bar,holder.retry,holder.image)

        holder.image.setOnClickListener {
            if(isNetworkAvailable(mContext)){
            holder.progress_bar.visibility = View.VISIBLE
            holder.retry.visibility = View.GONE
            onImageRetry(datas.image,holder.progress_bar,holder.retry,holder.image)
            }else{
                toast("No Internet Connection",mContext)
            }
        }
        holder.itemView.setOnClickListener {
            if(isNetworkAvailable(mContext)){
                mContext.run(fun Context.() {
                    startActivity(
                        Intent(mContext, ProfileDetailsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("itemData", datas))
                })
            }else{
                toast("No Internet Connection",mContext)
            }
        }
    }

    private fun onImageRetry(image: String, progressBar: ProgressBar, retry: TextView, image1: AppCompatImageView
    ) {
        if(!image.equals("null")){
            Glide.with(mContext).load(image).listener(object :
                RequestListener<Drawable?> {
                override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable?>, isFirstResource: Boolean): Boolean {
                    progressBar.visibility = View.GONE
                    retry.visibility =View.VISIBLE
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any, target: Target<Drawable?>, dataSource: DataSource, isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility =View.GONE
                    return false
                }
            }).into(image1)
        } else{
            progressBar.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }


    override fun getItemCount(): Int {
        return sources.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class MyViewHolder(itemView: View?) :
        RecyclerView.ViewHolder(itemView!!) {

        val titleText : TextView
            get() = itemView.findViewById(R.id.name)
        val retry : TextView
            get() = itemView.findViewById(R.id.retry)
        val category : TextView
            get() = itemView.findViewById(R.id.category)
        val address : TextView
            get() = itemView.findViewById(R.id.address)
        val image : AppCompatImageView
            get() = itemView.findViewById(R.id.image)
        val progress_bar : ProgressBar
            get() = itemView.findViewById(R.id.progress_bar)
        val noImage : TextView
            get() = itemView.findViewById(R.id.noImage)
    }

    init {
        this.sources = sources
    }
}