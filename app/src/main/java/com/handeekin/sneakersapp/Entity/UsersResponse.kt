package com.handeekin.sneakersapp.Entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UsersResponse(@SerializedName("deger")
                         @Expose
                         var value:Int,
                         @SerializedName("mail_adres")
                         @Expose
                         var mailAdress:String,
                         @SerializedName("sifre")
                         @Expose
                         var password:String,
                         @SerializedName("ad_soyad")
                         @Expose
                         var nameSurname:String,
                         @SerializedName("telefon")
                         @Expose
                         var telephone:String) {
}