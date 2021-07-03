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


class DiscountFragmentViewModel : ViewModel() {

    var salesitemsList = MutableLiveData<List<ItemsClass>>()
    val idaor = ItemsDAORepository()
    var success = MutableLiveData<Int>()




    init {
        salesitemsList = idaor.getDiscountItems()
        getSalesItems()
        success = idaor.discountSuccess()
    }



    fun itemSales(){
        idaor.salesItemChange(661,1)
        idaor.salesItemChange(662,1)
        idaor.salesItemChange(667,1)
    }

    fun getSalesItems(){
        idaor.getSalesItem()
    }



}