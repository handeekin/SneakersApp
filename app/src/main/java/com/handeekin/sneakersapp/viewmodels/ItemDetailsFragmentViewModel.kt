package com.handeekin.sneakersapp.viewmodels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.repos.ItemsDAORepository

class ItemDetailsFragmentViewModel : ViewModel() {

    //done ish

    var itemsList = MutableLiveData<List<ItemsClass>>()
    val idaor = ItemsDAORepository()


    init {
        itemsList = idaor.getItems()
    }
    fun addedToCart(id:Int,sepet_durum:Int){
        idaor.changeCartSit(id,sepet_durum)
    }



}