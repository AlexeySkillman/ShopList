package com.example.shoplist.presentation

import android.view.View
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.R
import com.example.shoplist.databinding.ItemShopDisabledBinding

// val использовался в круглых скобках (Родительское view)
class  ShopItemViewHolder(
        val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)