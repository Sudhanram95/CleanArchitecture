package com.example.cleanarchitecturetryout.ui.ecommerce.cart.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.databinding.CartItemBinding
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel.CartViewModel
import com.squareup.picasso.Picasso

class CartAdapter(val cartViewModel: CartViewModel, val cartList:MutableList<CartModel>) : RecyclerView.Adapter<CartAdapter.Companion.MyViewHolder>() {

    lateinit var itemBinding: CartItemBinding

    companion object {
        class MyViewHolder(val itemBinding: CartItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(cartModel: CartModel) {
                itemBinding.cart = cartModel
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cart_item, parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val cartModel = cartList.get(position)

        Picasso.get().load(cartModel.productImage).centerCrop().fit().into(itemBinding.imgItem)

        itemBinding.txtMinus.setOnClickListener(View.OnClickListener {
            cartViewModel.updateItemQuantity(cartModel, position, false)
            cartViewModel.updateGrabdTotal()
        })

        itemBinding.txtPlus.setOnClickListener(View.OnClickListener {
            cartViewModel.updateItemQuantity(cartModel, position,true)
            cartViewModel.updateGrabdTotal()
        })

        holder.bind(cartModel)
    }

    fun removeItem(cartModel: CartModel) {
        cartList.remove(cartModel)
        if(cartList.isEmpty()) {
            cartViewModel.getAllCartItemsFromDb()
        }
//        (context as MainActivity).updateCartCount()
    }
}