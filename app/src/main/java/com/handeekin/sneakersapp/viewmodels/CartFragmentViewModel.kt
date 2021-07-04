package com.handeekin.sneakersapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.repos.ItemsDAORepository

class CartFragmentViewModel : ViewModel() {

    var cartItemsList = MutableLiveData<List<ItemsClass>>()
    var success = MutableLiveData<Int>()
    val idaor = ItemsDAORepository()

    init {
        itemsAddedCart()
        cartItemsList = idaor.getCartItems()
    }
    fun itemsAddedCart() {
        idaor.CartAddedItems()
        cartItemsList = idaor.getCartItems()
    }

    fun itemsDeletedCart(id:Int,sepet_durum:Int){
        idaor.changeCartSit(id,sepet_durum)
    }


}



