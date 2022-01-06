package com.example.shoplist.domain

data class ShopItem (
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID // Не обязательные поля в конце указываются
) {
    companion object {
        const val UNDEFINED_ID = 0 // -1 означает что обьект еще не создан
    }
}