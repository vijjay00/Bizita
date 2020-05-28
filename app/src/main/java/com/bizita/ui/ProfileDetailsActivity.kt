package com.bizita.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bizita.R
import com.bizita.data.Succes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_profile_details.*

class ProfileDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)

        val item = intent.getParcelableExtra<Succes>("itemData")

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = item?.name
        }

        if(!item?.image.equals("null")){
            Glide.with(applicationContext).load(item.image).listener(object :
                RequestListener<Drawable?> {
                override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable?>, isFirstResource: Boolean): Boolean {
                    progress_bar.setVisibility(View.GONE)
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any, target: Target<Drawable?>, dataSource: DataSource, isFirstResource: Boolean
                ): Boolean {
                    progress_bar.setVisibility(View.GONE)
                    return false
                }
            }).into(image)
        } else{
            progress_bar.setVisibility(View.GONE)
            noImage.setVisibility(View.VISIBLE)
        }

        idnumb.text = String.format(resources.getString(R.string.id), item?.id)
        eName.text = String.format(resources.getString(R.string.names), item?.name)
        categ.text = String.format(resources.getString(R.string.catg), item?.category)
        addrs.text = String.format(resources.getString(R.string.addres), item?.address)
        desc.text = String.format(resources.getString(R.string.descp), item?.description)
        eContact.text = String.format(resources.getString(R.string.contact), item?.contact)
        eCode.text = String.format(resources.getString(R.string.empcode), item?.empcode)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
