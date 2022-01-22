package com.example.shoplist.di

import android.app.Application
import com.example.shoplist.di.annotations.ApplicationScope
import com.example.shoplist.presentation.MainActivity
import com.example.shoplist.presentation.ShopItemFragment
import com.example.shoplist.presentation.ShopListApp
import dagger.BindsInstance
import dagger.Component



@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

//    fun inject(application: ShopListApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent // Важно Возвращаем ApplicationComponent а не application
    }
}