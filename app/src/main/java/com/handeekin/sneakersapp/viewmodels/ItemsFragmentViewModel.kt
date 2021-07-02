package com.handeekin.sneakersapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.entityy.ItemsResponse
import com.handeekin.sneakersapp.repos.ItemsDAORepository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemsFragmentViewModel : ViewModel() {

    var itemsList = MutableLiveData<List<ItemsClass>>()

    val idaor = ItemsDAORepository()


    init {
        showMyItems()
        itemsList = idaor.getItems()
    }



    fun showMyItems(){
        idaor.allProducts()
    }



}