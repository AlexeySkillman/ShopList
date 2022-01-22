package com.example.shoplist.di

import android.app.Application
import com.example.shoplist.data.AppDatabase
import com.example.shoplist.data.ShopListDao
import com.example.shoplist.data.ShopListRepositoryImpl
import com.example.shoplist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{

        @Singleton
        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }

    }
}