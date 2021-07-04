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
        getSalesItems()
        success = idaor.discountSuccess()
        cartItemsList = idaor.getCartItems()
    }

    fun itemsAddedCart() {
        idaor.CartAddedItems()
    }

    /*fun itemsDeletedCart(){
        idaor.CartDeletedItems()
    }*/

    fun itemsDeletedCart(id:Int,sepet_durum:Int){
        idaor.changeCartSit(id,sepet_durum)
    }
    fun getSalesItems(){
        idaor.getSalesItem()
    }


}



