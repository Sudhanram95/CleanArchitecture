package com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryDetailModel
import com.example.cleanarchitecturetryout.domain.ecommerce.ProductDetailModel
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.view.ProductDetailFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.view.EcommerceActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_product_list.view.*

class ProductListFragment: DaggerFragment(), ItemClickListener {

    lateinit var productList: List<ProductDetailModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productList = (arguments!!.getSerializable("categoryDetail") as CategoryDetailModel).itemList
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_product_list, container, false)
        initializeView(rootView)
        return rootView
    }

    private fun initializeView(view: View) {
        val productAdapter = ProductAdapter(this, productList)
        view.rvProductList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        view.rvProductList.adapter = productAdapter
    }

    override fun onItemClick(model: Any) {
        val bundle = Bundle()
        bundle.putSerializable("productDetail", model as ProductDetailModel)
        (context as EcommerceActivity).replaceFragment(ProductDetailFragment(), bundle)
    }
}