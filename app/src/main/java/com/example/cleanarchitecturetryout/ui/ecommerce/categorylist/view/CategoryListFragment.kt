package com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view

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
import com.example.cleanarchitecturetryout.domain.categorylist.CategoryDetailModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ItemClickListener
import com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.viewmodel.CategoryListViewModel
import com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view.ProductListFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.view.EcommerceActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_category_list.view.*
import javax.inject.Inject

class CategoryListFragment: DaggerFragment(), ItemClickListener {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var categListViewModel: CategoryListViewModel
    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        categListViewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoryListViewModel::class.java)
        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_category_list, container, false)
        categListViewModel.getCategoryList()
        return rootView
    }

    private fun observeViewModel() {
        categListViewModel.observeCategoryList().observe(this, object : Observer<Resource<List<CategoryDetailModel>>> {
            override fun onChanged(resource: Resource<List<CategoryDetailModel>>?) {
                when(resource!!.status) {
                    Resource.Status.SUCCESS -> {
                        val categoryList = resource.data!!
                        val categoryAdapter = CategoryAdapter(this@CategoryListFragment, categoryList)
                        rootView.rvCategoryList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                        rootView.rvCategoryList.adapter = categoryAdapter
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
        bundle.putSerializable("selectedId", (model as CategoryDetailModel).categoryId)
        (context as EcommerceActivity).replaceFragment(ProductListFragment(), bundle)
    }
}