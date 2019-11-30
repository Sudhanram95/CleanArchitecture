package com.example.cleanarchitecturetryout.ui.ecommerce.cart.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.databinding.FragmentCartBinding
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel.CartViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CartFragment: DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var cartViewModel: CartViewModel
    lateinit var cartBinding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cartViewModel = ViewModelProviders.of(this, viewModelFactory).get(CartViewModel::class.java)
        observeViewModel()
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

                    }

                    else -> {
                        cartBinding.cartEmpty = resource.error!!.message
                    }
                }
            }
        })
    }
}