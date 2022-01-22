package com.example.shoplist.di

import android.app.Application
import com.example.shoplist.data.AppDatabase
import com.example.shoplist.data.ShopListDao
import com.example.shoplist.data.ShopListRepositoryImpl
import com.example.shoplist.di.annotations.ApplicationScope
import com.example.shoplist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }

    }
}