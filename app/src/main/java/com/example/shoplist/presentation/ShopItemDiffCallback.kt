package com.example.shoplist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoplist.domain.ShopItem

// DiffUtil.Callback - сравнивает списки
// DiffUtil.ItemCallback - сравнивает отдельные елементы
class ShopItemDiffCallback: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}