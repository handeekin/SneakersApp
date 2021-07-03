package com.handeekin.sneakersapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.repos.ItemsDAORepository

class CartFragmentViewModel : ViewModel() {

    var itemsList = MutableLiveData<List<ItemsClass>>()

    val idaor = ItemsDAORepository()


    init {
        itemSales()
        itemsList = idaor.getItems()
    }


    fun itemSales() {

    }

}



