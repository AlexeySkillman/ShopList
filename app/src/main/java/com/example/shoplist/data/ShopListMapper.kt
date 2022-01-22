package com.example.shoplist.data

import com.example.shoplist.domain.ShopItem
import javax.inject.Inject

// Чтлбы трасформировать данные

class ShopListMapper @Inject constructor() {
    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDbModel (
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enabled = shopItem.enabled
    )
    fun mapDbModelToEntity(shopItemDbModel: ShopItemDbModel) = ShopItem(
            id = shopItemDbModel.id,
            name = shopItemDbModel.name,
            count = shopItemDbModel.count,
            enabled = shopItemDbModel.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}