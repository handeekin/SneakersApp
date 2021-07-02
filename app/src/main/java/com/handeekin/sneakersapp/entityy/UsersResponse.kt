package com.handeekin.sneakersapp.entityy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.handeekin.sneakersapp.entityy.UsersClass

data class UsersResponse(@SerializedName("kullanicilar")
                         @Expose
                         var users:List<UsersClass>,
                         @SerializedName("deger")
                         @Expose
                         var value:Int) {
}