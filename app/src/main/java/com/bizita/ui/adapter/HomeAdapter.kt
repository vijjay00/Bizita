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
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bizita.R
import com.bizita.data.Succes
import com.bizita.databinding.ItemDisplayBinding
import com.bizita.ui.ProfileDetailsActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.newsfeed.utils.isNetworkAvailable
import com.newsfeed.utils.toast

class HomeAdapter  (val mContext: Context) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private lateinit var sources: ArrayList<Succes> ;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemDisplayBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_display, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val datas = sources.get(position)
        holder.bind(sources.get(position))

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

    fun setAdapterList(list: ArrayList<Succes> ){
        this.sources = list
        notifyDataSetChanged()
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

    inner class MyViewHolder(val binding: ItemDisplayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val retry : TextView
            get() = binding.root.findViewById(R.id.retry)
        val image : AppCompatImageView
            get() = binding.root.findViewById(R.id.image)
        val progress_bar : ProgressBar
            get() = binding.root.findViewById(R.id.progress_bar)
        val noImage : TextView
            get() = binding.root.findViewById(R.id.noImage)

        fun bind(data: Succes) {
            binding.model = data
            binding.executePendingBindings()
        }
    }
}