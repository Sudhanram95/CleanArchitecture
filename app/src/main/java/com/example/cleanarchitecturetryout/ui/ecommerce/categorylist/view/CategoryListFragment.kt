package com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryDetailModel
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryListModel
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view.ProductListFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.view.EcommerceActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_category_list.view.*

class CategoryListFragment: DaggerFragment(),
    ItemClickListener {

    lateinit var categoryList: List<CategoryDetailModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        categoryList = (arguments!!.getSerializable("CategoryList") as CategoryListModel).categoryList
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)
        initializeView(view)
        return view
    }

    private fun initializeView(view: View) {
        val categoryAdapter = CategoryAdapter(this, categoryList)
        view.rvCategoryList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        view.rvCategoryList.adapter = categoryAdapter
    }

    override fun onItemClick(model: Any) {
        val bundle = Bundle()
        bundle.putSerializable("categoryDetail", model as CategoryDetailModel)
        (context as EcommerceActivity).replaceFragment(ProductListFragment(), bundle)
    }
}