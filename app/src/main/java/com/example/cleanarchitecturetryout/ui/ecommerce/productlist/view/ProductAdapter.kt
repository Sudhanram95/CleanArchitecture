package com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.databinding.ProductItemBinding
import com.example.cleanarchitecturetryout.domain.ecommerce.ProductDetailModel
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.squareup.picasso.Picasso

class ProductAdapter(val itemClickListener: ItemClickListener, val productList: List<ProductDetailModel>): RecyclerView.Adapter<ProductAdapter.Companion.MyViewHolder>() {

    lateinit var itemBinding: ProductItemBinding

    companion object {
        class MyViewHolder(val itemBinding: ProductItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(productDetailModel: ProductDetailModel) {
                itemBinding.product = productDetailModel
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.product_item, parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val productDetail = productList.get(position)
        Picasso.get()
            .load(productDetail.imageList.get(0))
            .centerCrop()
            .fit()
            .into(itemBinding.imgProduct)

        holder.bind(productDetail)

        itemBinding.cardProduct.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClick(productList.get(position))
        })
    }
}