package com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.product.ProductDetailModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.view.ProductDetailFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.productlist.viewmodel.ProductListViewModel
import com.example.cleanarchitecturetryout.ui.ecommerce.view.EcommerceActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_product_list.view.*
import javax.inject.Inject

class ProductListFragment: DaggerFragment(), ItemClickListener {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var productListViewModel: ProductListViewModel
    lateinit var selectedCategoryId: String
    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectedCategoryId = arguments!!.getString("selectedId", "")

        productListViewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductListViewModel::class.java)
        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_product_list, container, false)
        productListViewModel.getAllProducts(selectedCategoryId)
        return rootView
    }

    private fun observeViewModel() {
        productListViewModel.observeAllProducts().observe(this, object : Observer<Resource<List<ProductDetailModel>>> {
            override fun onChanged(resource: Resource<List<ProductDetailModel>>?) {
                when(resource!!.status) {
                    Resource.Status.SUCCESS -> {
                        val productList = resource.data!!
                        val productAdapter = ProductAdapter(this@ProductListFragment, productList)
                        rootView.rvProductList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                        rootView.rvProductList.adapter = productAdapter
                    }

                    else -> {
                        //Handle error
                    }
                }
            }
        })
    }

    override fun onItemClick(model: Any) {
        val bundle = Bundle()
        bundle.putSerializable("productDetail", model as ProductDetailModel)
        (context as EcommerceActivity).replaceFragment(ProductDetailFragment(), bundle)
    }
}