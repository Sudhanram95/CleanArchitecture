package com.example.cleanarchitecturetryout.ui.ecommerce.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryListModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.view.CartFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view.CategoryListFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.viewmodel.EcommerceViewModel
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_ecommerce.*
import javax.inject.Inject

class EcommerceActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var ecommerceViewModel: EcommerceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecommerce)

        ecommerceViewModel = ViewModelProviders.of(this, viewModelFactory).get(EcommerceViewModel::class.java)
        ecommerceViewModel.getAllProductsResponse()
        observeViewModel()

        ll_cart.setOnClickListener {
            replaceFragment(CartFragment(), null)
        }
    }

    fun observeViewModel() {
        ecommerceViewModel.observeProducts().observe(this, object : Observer<Resource<CategoryListModel>> {
            override fun onChanged(resource: Resource<CategoryListModel>?) {
                when(resource!!.status) {
                    Resource.Status.SUCCESS -> {
                        val bundle = Bundle()
                        bundle.putSerializable("CategoryList", resource.data)
                        addFragment(CategoryListFragment(), bundle)
                    }
                    else -> {
                        Log.e("EcommerceActivity", "Error: ${resource.error?.message}")
                    }
                }
            }
        })
    }

    fun replaceFragment(fragment: DaggerFragment, bundle: Bundle?) {
        bundle?.let { fragment.arguments = it }
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment, fragment.javaClass.name)
            .addToBackStack(null)
            .commit()
    }

    fun addFragment(fragment: DaggerFragment, bundle: Bundle) {
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, fragment, fragment.javaClass.name)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}
