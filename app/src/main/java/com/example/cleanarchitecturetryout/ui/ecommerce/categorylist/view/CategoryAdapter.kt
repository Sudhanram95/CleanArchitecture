package com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryDetailModel
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.squareup.picasso.Picasso

class CategoryAdapter(val itemClickListener: ItemClickListener, val categoryList: List<CategoryDetailModel>) : RecyclerView.Adapter<CategoryAdapter.Companion.MyViewHolder>() {

    companion object {
        class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view)
        {
            var imgCategory: ImageView
            var llLeft: LinearLayout
            var llRight: LinearLayout
            var txtCategoryLeft: TextView
            var txtItemCountLeft: TextView
            var txtCategoryRight: TextView
            var txtItemCountRight: TextView
            init {
                imgCategory = view.findViewById(R.id.img_category)
                llLeft = view.findViewById(R.id.ll_left_category)
                llRight = view.findViewById(R.id.ll_right_category)
                txtCategoryLeft = view.findViewById(R.id.txt_left_category_name)
                txtItemCountLeft = view.findViewById(R.id.txt_left_item_count)
                txtCategoryRight = view.findViewById(R.id.txt_right_category_name)
                txtItemCountRight = view.findViewById(R.id.txt_right_item_count)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Picasso.get()
            .load(categoryList.get(position).categoryImage)
            .centerCrop()
            .fit()
            .into(holder.imgCategory)

        if(position %2 == 0) {
            holder.llRight.visibility = View.VISIBLE
            holder.txtCategoryRight.text = categoryList.get(position).categoryName
            holder.txtItemCountRight.text = "${categoryList.get(position).itemList.size} Products"
        } else {
            holder.llLeft.visibility = View.VISIBLE
            holder.txtCategoryLeft.text = categoryList.get(position).categoryName
            holder.txtItemCountLeft.text = "${categoryList.get(position).itemList.size} Products"
        }

        holder.imgCategory.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClick(categoryList.get(position))
        })
    }
}