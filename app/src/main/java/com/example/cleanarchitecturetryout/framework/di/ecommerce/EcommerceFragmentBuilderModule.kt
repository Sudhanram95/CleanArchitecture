package com.example.cleanarchitecturetryout.framework.di.ecommerce

import com.example.cleanarchitecturetryout.framework.di.cart.CartModule
import com.example.cleanarchitecturetryout.framework.di.cart.CartScope
import com.example.cleanarchitecturetryout.framework.di.cart.CartViewModelModule
import com.example.cleanarchitecturetryout.framework.di.categorylist.CategoryListModule
import com.example.cleanarchitecturetryout.framework.di.categorylist.CategoryListScope
import com.example.cleanarchitecturetryout.framework.di.categorylist.CategoryListViewModelModule
import com.example.cleanarchitecturetryout.framework.di.productdetail.ProductDetailModule
import com.example.cleanarchitecturetryout.framework.di.productdetail.ProductDetailScope
import com.example.cleanarchitecturetryout.framework.di.productdetail.ProductDetailViewModelModule
import com.example.cleanarchitecturetryout.framework.di.productlist.ProductListModule
import com.example.cleanarchitecturetryout.framework.di.productlist.ProductListScope
import com.example.cleanarchitecturetryout.framework.di.productlist.ProductListViewModelModule
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.view.CartFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.view.CategoryListFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.view.ProductDetailFragment
import com.example.cleanarchitecturetryout.ui.ecommerce.productlist.view.ProductListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class EcommerceFragmentBuilderModule {

    @CategoryListScope
    @ContributesAndroidInjector(modules = [CategoryListModule::class, CategoryListViewModelModule::class])
    abstract fun contributeCategoryListFragment(): CategoryListFragment

    @ProductListScope
    @ContributesAndroidInjector(modules = [ProductListModule::class, ProductListViewModelModule::class])
    abstract fun contributeProductListFragment(): ProductListFragment

    @ProductDetailScope
    @ContributesAndroidInjector(modules = [ProductDetailModule::class, ProductDetailViewModelModule::class])
    abstract fun contributeProductDetailFragment(): ProductDetailFragment

    @CartScope
    @ContributesAndroidInjector(modules = [CartModule::class, CartViewModelModule::class])
    abstract fun contributeCartFragment(): CartFragment
}