package com.example.cleanarchitecturetryout.framework.di.categorylist

import android.content.Context
import com.example.cleanarchitecturetryout.data.categorylist.CategoryListRepository
import com.example.cleanarchitecturetryout.data.categorylist.CategoryListSource
import com.example.cleanarchitecturetryout.framework.source.categorylist.CategoryListSourceImpl
import com.example.cleanarchitecturetryout.interactor.categorylist.GetAllCategories
import com.example.cleanarchitecturetryout.ui.TryoutApplication
import dagger.Module
import dagger.Provides

@Module
class CategoryListModule {

    @CategoryListScope
    @Provides
    fun provideGetAllCategories(repository: CategoryListRepository): GetAllCategories {
        return GetAllCategories(repository)
    }

    @CategoryListScope
    @Provides
    fun provideCategoryListRepository(source: CategoryListSource): CategoryListRepository {
        return CategoryListRepository(source)
    }

    @CategoryListScope
    @Provides
    fun provideCategoryListSource(): CategoryListSource {
        return CategoryListSourceImpl(TryoutApplication.applicationContext())
    }
}