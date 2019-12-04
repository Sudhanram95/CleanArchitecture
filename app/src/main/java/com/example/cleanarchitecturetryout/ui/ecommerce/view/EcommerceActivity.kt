package com.example.cleanarchitecturetryout.ui.ecommerce.view

import android.os.Bundle
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.view.CartFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view.CategoryListFragment
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_ecommerce.*

class EcommerceActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecommerce)

        addFragment(CategoryListFragment(), null)

        ll_cart.setOnClickListener {
            replaceFragment(CartFragment(), null)
        }
    }

    fun replaceFragment(fragment: DaggerFragment, bundle: Bundle?) {
        bundle?.let { fragment.arguments = it }
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment, fragment.javaClass.name)
            .addToBackStack(null)
            .commit()
    }

    fun addFragment(fragment: DaggerFragment, bundle: Bundle?) {
        bundle?.let { fragment.arguments = it }
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
