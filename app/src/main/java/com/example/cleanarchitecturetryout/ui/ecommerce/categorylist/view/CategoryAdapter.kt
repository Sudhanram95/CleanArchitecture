package com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.databinding.CategoryItemBinding
import com.example.cleanarchitecturetryout.domain.categorylist.CategoryDetailModel
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.squareup.picasso.Picasso

class CategoryAdapter(val itemClickListener: ItemClickListener, val categoryList: List<CategoryDetailModel>) : RecyclerView.Adapter<CategoryAdapter.Companion.MyViewHolder>() {

    lateinit var categoryItemBinding: CategoryItemBinding

    companion object {
        class MyViewHolder(val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root)
        {
            fun bind(categoryDetailModel: CategoryDetailModel) {
                itemBinding.category = categoryDetailModel
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        categoryItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        val myViewHolder = MyViewHolder(categoryItemBinding)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val categoryDetail = categoryList.get(position)
        Picasso.get()
            .load(categoryDetail.categoryImage)
            .centerCrop()
            .fit()
            .into(categoryItemBinding.imgCategory)

        categoryDetail.isLeft = position%2 == 0

        holder.bind(categoryDetail)

        categoryItemBinding.imgCategory.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClick(categoryList.get(position))
        })
    }
}