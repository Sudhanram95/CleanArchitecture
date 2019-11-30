package com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.domain.ecommerce.ProductDetailModel
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.squareup.picasso.Picasso

class ProductAdapter(val itemClickListener: ItemClickListener, val productList: List<ProductDetailModel>): RecyclerView.Adapter<ProductAdapter.Companion.MyViewHolder>() {

    companion object {
        class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view)
        {
            var imgProduct: ImageView
            var txtProductname: TextView
            var txtPrice: TextView
            var cardRoot: CardView
            init {
                imgProduct = view.findViewById(R.id.img_product)
                txtProductname = view.findViewById(R.id.txt_product_name)
                txtPrice = view.findViewById(R.id.txt_price)
                cardRoot = view.findViewById(R.id.card_product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Picasso.get()
            .load(productList.get(position).imageList.get(0))
            .centerCrop()
            .fit()
            .into(holder.imgProduct)

        holder.txtProductname.text = productList.get(position).name
        holder.txtPrice.text = "Rs.${productList.get(position).price}"

        holder.cardRoot.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClick(productList.get(position))
        })
    }
}