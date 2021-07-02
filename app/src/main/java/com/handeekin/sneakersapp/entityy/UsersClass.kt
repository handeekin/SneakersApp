package com.handeekin.sneakersapp.entityy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersClass(@SerializedName("id")
                 @Expose
                 var id:Int,
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
                 var telephone:String,
                 @SerializedName("deger")
                 @Expose
                 var user_val:Int):Serializable{
}