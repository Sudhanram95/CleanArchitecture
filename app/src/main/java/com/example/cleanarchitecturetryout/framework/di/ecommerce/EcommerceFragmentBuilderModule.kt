package com.example.cleanarchitecturetryout.framework.di.ecommerce

import com.example.cleanarchitecturetryout.framework.di.categorylist.CategoryListScope
import com.example.cleanarchitecturetryout.framework.di.productdetail.ProductDetailModule
import com.example.cleanarchitecturetryout.framework.di.productdetail.ProductDetailScope
import com.example.cleanarchitecturetryout.framework.di.productdetail.ProductDetailViewModelModule
import com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view.CategoryListFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.view.ProductDetailFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view.ProductListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class EcommerceFragmentBuilderModule {

    @CategoryListScope
    @ContributesAndroidInjector
    abstract fun contributeCategoryListFragment(): CategoryListFragment

    @ContributesAndroidInjector
    abstract fun contributeProductListFragment(): ProductListFragment

    @ProductDetailScope
    @ContributesAndroidInjector(modules = [ProductDetailModule::class, ProductDetailViewModelModule::class])
    abstract fun contributeProductDetailFragment(): ProductDetailFragment
}