package com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.squareup.picasso.Picasso

class ProductThumbnailAdapter(val itemClickListener: ItemClickListener, val thumbnailList: List<String>): RecyclerView.Adapter<ProductThumbnailAdapter.Companion.MyViewHolder>() {

    companion object {
        class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view)
        {
            var imgThumbnail: ImageView
            init {
                imgThumbnail = view.findViewById(R.id.img_thumbnail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thumbnail_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return thumbnailList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Picasso.get()
            .load(thumbnailList.get(position))
            .centerCrop()
            .fit()
            .into(holder.imgThumbnail)

        holder.imgThumbnail.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClick(thumbnailList.get(position))
        })
    }
}