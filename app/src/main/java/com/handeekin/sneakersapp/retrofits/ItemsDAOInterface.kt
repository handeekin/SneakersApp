package com.handeekin.sneakersapp.retrofits

import com.handeekin.sneakersapp.entityy.CRUDResponse
import com.handeekin.sneakersapp.entityy.ItemsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//Call<Response> kısmını sormam lazım

interface ItemsDAOInterface {

    @POST("urunler.php")
    @FormUrlEncoded
    fun myItems(
        @Field("satici_adi") satici_adi:String,
    ): Call<ItemsResponse>


    @POST("indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun change_sales_item(
        @Field("id") id: Int,
        @Field("urun_indirimli_mi") urun_indirimli_mi :Int): Call<CRUDResponse>

    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun change_cart_situation(
        @Field("id") id: Int,
        @Field("sepet_durum") sepet_durum :Int): Call<CRUDResponse>

    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun addItem(
        @Field("satici_adi") satici_adi:String,
        @Field("urun_adi") urun_adi:String,
        @Field("urun_fiyat") urun_fiyat:String,
        @Field("urun_aciklama") urun_aciklama:String,
        @Field("urun_gorsel_url") urun_gorsel_url:String): Call<CRUDResponse>





}