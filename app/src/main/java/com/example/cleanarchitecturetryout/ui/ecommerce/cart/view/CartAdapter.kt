package com.example.cleanarchitecturetryout.ui.ecommerce.cart.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel.CartViewModel
import com.squareup.picasso.Picasso

class CartAdapter(val cartViewModel: CartViewModel, val cartList:MutableList<CartModel>) : RecyclerView.Adapter<CartAdapter.Companion.MyViewHolder>() {

    companion object {
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var imgItem: ImageView
            var txtProductName: TextView
            var txtPrice: TextView
            var txtMinus: TextView
            var txtPlus: TextView
            var txtQuantity: TextView
            var txtSubTotal: TextView
            init {
                imgItem = view.findViewById(R.id.img_item)
                txtProductName = view.findViewById(R.id.txt_product_name)
                txtPrice = view.findViewById(R.id.txt_item_price)
                txtMinus = view.findViewById(R.id.txt_minus)
                txtPlus = view.findViewById(R.id.txt_plus)
                txtQuantity = view.findViewById(R.id.txt_quantity)
                txtSubTotal = view.findViewById(R.id.txt_sub_total)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val cartModel = cartList.get(position)

        Picasso.get().load(cartModel.productImage).centerCrop().fit().into(holder.imgItem)
        holder.txtProductName.text = cartModel.productName
        holder.txtPrice.text = "Rs. ${cartModel.itemPrice}"
        holder.txtQuantity.text = cartModel.quantity.toString()
        holder.txtSubTotal.text = "Rs. ${cartModel.subTotal}"

        holder.txtMinus.setOnClickListener(View.OnClickListener {
            cartViewModel.updateItemQuantity(cartModel, position, false)
            cartViewModel.updateGrabdTotal()
        })

        holder.txtPlus.setOnClickListener(View.OnClickListener {
            cartViewModel.updateItemQuantity(cartModel, position,true)
            cartViewModel.updateGrabdTotal()
        })
    }

    fun removeItem(cartModel: CartModel) {
        cartList.remove(cartModel)
        if(cartList.isEmpty()) {
            cartViewModel.getAllCartItemsFromDb()
        }
//        (context as MainActivity).updateCartCount()
    }
}