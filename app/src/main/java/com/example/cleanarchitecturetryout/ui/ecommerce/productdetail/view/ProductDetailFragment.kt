package com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.databinding.FragmentProductDetailBinding
import com.example.cleanarchitecturetryout.domain.ecommerce.ProductDetailModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.viewmodel.ProductDetailViewModel
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_product_detail.view.*
import javax.inject.Inject

class ProductDetailFragment: DaggerFragment(), ItemClickListener {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var productDetailViewModel: ProductDetailViewModel
    lateinit var productDetailModel: ProductDetailModel
    lateinit var productDetailBinding: FragmentProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productDetailModel = arguments!!.getSerializable("productDetail") as ProductDetailModel

        productDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductDetailViewModel::class.java)
        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)
        initializeView()
        return productDetailBinding.root
    }

    private fun initializeView() {
        productDetailBinding.product = productDetailModel
        loadImage(productDetailModel.imageList.get(0))

        val thumbnailAdapter = ProductThumbnailAdapter(this, productDetailModel.imageList)
        productDetailBinding.rvProductThumbnail.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        productDetailBinding.rvProductThumbnail.adapter = thumbnailAdapter

        productDetailBinding.btnAddCart.setOnClickListener { productDetailViewModel.addProductToCart(productDetailModel) }
    }

    private fun observeViewModel() {
        productDetailViewModel.observeAddToCart().observe(this, object : Observer<Resource<String>> {
            override fun onChanged(resource: Resource<String>?) {
                Toast.makeText(context!!, resource?.data, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(model: Any) {
        loadImage(model as String)
    }

    private fun loadImage(url: String) {
        Picasso.get().load(url)
            .centerCrop()
            .fit()
            .into(productDetailBinding.imgProductPreview)
    }
}