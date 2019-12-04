package com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.categorylist.CategoryDetailModel
import com.example.cleanarchitecturetryout.interactor.categorylist.GetAllCategories
import javax.inject.Inject

class CategoryListViewModel @Inject constructor(
    val getAllCategories: GetAllCategories
): ViewModel() {

    private val categoryListLiveData = MutableLiveData<Resource<List<CategoryDetailModel>>>()

    fun observeCategoryList() = categoryListLiveData

    fun getCategoryList() {
        val categoryList = getAllCategories()
        if (!categoryList.isEmpty()) {
            categoryListLiveData.value = Resource.success(categoryList)
        } else {
            categoryListLiveData.value = Resource.error(Throwable("Something went wrong"), null)
        }
    }

}