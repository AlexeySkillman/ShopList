package com.example.shoplist.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.shoplist.domain.AddShopItemUseCase
import com.example.shoplist.domain.EditShopItemUseCase
import com.example.shoplist.domain.GetShopItemUseCase
import com.example.shoplist.domain.ShopItem
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ShopItemViewModel @Inject constructor(
    private val getShopItemUseCase: GetShopItemUseCase,
    private val addShopItemUseCase: AddShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase
): ViewModel() {

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getShopItem(shopItemId: Int){
        viewModelScope.launch {
            val item = getShopItemUseCase.getShopItem(shopItemId)
            _shopItem.postValue(item)
        }
    }

    fun addShopItem(inputName: String?, inputCount: String?){
        viewModelScope.launch {
            val name = parseName(inputName)
            val count = parseCount(inputCount)
            val fieldsValid = validateImput(name, count)
            if(fieldsValid){
                val shopItem = ShopItem(name, count, true)
                Log.d("Z_ShopItem" , shopItem.toString()) // Покажет Элемент был До редактирования. Но в процессе Сохранения
                addShopItemUseCase.addShopItem(shopItem)
                finishWork()
            }
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?){
        viewModelScope.launch {
            val name = parseName(inputName)
            val count = parseCount(inputCount)
            val fieldsValid = validateImput(name, count)
            if(fieldsValid){
                _shopItem.value?.let{
                    Log.d("Z_ShopItem" , it.toString()) // Покажет Элемент был До редактирования. Но в процессе Сохранения
                    val item = it.copy(name = name, count = count) // Копирует Элемент
                    editShopItemUseCase.editShopItem(item)
                    finishWork()
                }
            }
        }
    }

    private fun parseName(inputName: String?):String{
        return inputName?.trim() ?: ""
    }
    private fun parseCount(inputCount: String?):Int{
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception){
            0
        }
    }
    private fun validateImput(name: String, count: Int): Boolean{
        var result = true
        if(name.isBlank()){
            _errorInputName.value = true
            result = false
        }
        if(count <= 0 ){
            _errorInputCount.value = true
            result = false
        }
        return result
    }
    fun resetErrorInputName(){
        _errorInputName.value = false
    }
    fun resetErrorInputCount(){
        _errorInputCount.value = false
    }
    private fun finishWork(){
        // _shouldCloseScreen.value = Unit // Это можно только на главном потоке
        _shouldCloseScreen.postValue(Unit)
    }

}