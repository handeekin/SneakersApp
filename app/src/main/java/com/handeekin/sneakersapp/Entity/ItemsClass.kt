package com.handeekin.sneakersapp.Entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemsClass(@SerializedName("id")
            @Expose
            var id:Int,
            @SerializedName("sepet_durum")
            @Expose
            var cartSituation:Int,
            @SerializedName("satici_adi")
            @Expose
            var sellerNameSurname:String,
            @SerializedName("urun_adi")
            @Expose
            var itemName:String,
            @SerializedName("urun_fiyat")
            @Expose
            var itemPrice:String,
            @SerializedName("urun_aciklama")
            @Expose
            var itemDescription:String,
            @SerializedName("urun_gorsel_url")
            @Expose
            var itemPictureUrl:String,
            @SerializedName("urun_indirimli_mi")
            @Expose
            var issale:Int
            ) {
}