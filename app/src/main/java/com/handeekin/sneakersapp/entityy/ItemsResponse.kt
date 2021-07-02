package com.handeekin.sneakersapp.entityy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.handeekin.sneakersapp.entityy.ItemsClass

data class ItemsResponse(@SerializedName("urunler")
                         @Expose
                         var items:List<ItemsClass>){
}