package com.example.cleanarchitecturetryout.ui.ecommerce.cart.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.databinding.FragmentCartBinding
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.model.CartUpdateModel
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel.CartViewModel
import com.google.gson.Gson
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CartFragment: DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var cartViewModel: CartViewModel
    lateinit var cartBinding: FragmentCartBinding
    lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cartViewModel = ViewModelProviders.of(this, viewModelFactory).get(CartViewModel::class.java)
        observeViewModel()
        observeCartUpdate()
        observeGrandTotal()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        cartViewModel.getAllCartItemsFromDb()
        return cartBinding.root
    }

    private fun observeViewModel() {
        cartViewModel.observeGetAllCartItems().observe(this, object : Observer<Resource<List<CartModel>>> {
            override fun onChanged(resource: Resource<List<CartModel>>?) {
                when(resource!!.status) {
                    Resource.Status.SUCCESS -> {
                        Log.e("CartFragment", "List: ${Gson().toJson(resource.data)}")
                        cartAdapter = CartAdapter(cartViewModel, resource.data!!.toMutableList())
                        cartBinding.rvCartList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                        cartBinding.rvCartList.adapter = cartAdapter
                    }

                    else -> {
                        cartBinding.cartEmpty = resource.error!!.message
                    }
                }
            }
        })
    }

    private fun observeCartUpdate() {
        cartViewModel.observeItemUpdate().observe(this, object : Observer<Resource<CartUpdateModel>> {
            override fun onChanged(resource: Resource<CartUpdateModel>?) {
                when(resource!!.status) {
                    Resource.Status.SUCCESS -> {
                        cartAdapter.notifyItemChanged(resource.data!!.position, resource.data!!.cartModel)
                    }

                    else -> {
                        cartAdapter.removeItem(resource.data!!.cartModel)
                        cartAdapter.notifyItemRemoved(resource.data!!.position)
                    }
                }
            }
        })
    }

    private fun observeGrandTotal() {
        cartViewModel.observeGrandTotal().observe(this, object : Observer<Int> {
            override fun onChanged(grandTotal: Int?) {
                cartBinding.txtGrandTotal.text = "Rs. $grandTotal"
            }
        })
    }
}