package com.handeekin.sneakersapp.Retrofit

import com.handeekin.sneakersapp.Entity.CRUDResponse
import com.handeekin.sneakersapp.Entity.ItemsResponse
import com.handeekin.sneakersapp.Entity.UsersResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//Call<Response> kısmını sormam lazım

interface ItemsUsersDAOInterface {
    @POST("/urunler.php")
    @FormUrlEncoded
    fun allItems(
        @Field("satici_adi") satici_adi:String,
    ): Call<ItemsResponse>

    @GET("/urunler.php")
    fun itemsSearch(
        @Field("id") id:Int,
        @Field("urun_adi") urun_adi:String,
        @Field("urun_fiyat") urun_fiyat:String,
        @Field("urun_aciklama") urun_aciklama:String,
        @Field("urun_gorsel_url") urun_gorsel_url:String,
        @Field("sepet_durum") sepet_durum:Int,
        @Field("urun_indirimli_mi") urun_indirimli_mi:Int): Call<ItemsResponse>

    @POST("/giris_yap.php")
    @FormUrlEncoded
    fun login(
        @Field("mail_adres") mail_adres:String,
        @Field("sifre") sifre:String): Call<UsersResponse>

    @GET("/giris_yap")
    fun LogIn(
        @Field("deger") deger:Int,
        @Field("mail_adres") mail_adres:String,
        @Field("sifre") sifre:String,
        @Field("ad_soyad") ad_soyad:String,
        @Field("telefon") telefon:String) : Call<UsersResponse>

    @POST("/indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun change_sales_item(
        @Field("id") id: Int,
        @Field("urun_indirimli_mi") urun_indirimli_mi :Int): Call<CRUDResponse>

    @POST("/sepet_durum_degistir.php")
    @FormUrlEncoded
    fun change_cart_situation(
        @Field("id") id: Int,
        @Field("sepet_durum") sepet_durum :Int): Call<CRUDResponse>

    @POST("/urun_ekle.php")
    fun addItem(
        @Field("satici_adi") satici_adi:String,
        @Field("urun_adi") urun_adi:String,
        @Field("urun_fiyat") urun_fiyat:String,
        @Field("urun_aciklama") urun_aciklama:String,
        @Field("urun_gorsel_url") urun_gorsel_url:String): Call<CRUDResponse>

    @POST("/uye_ol")
    fun signUp(
        @Field("mail_adres") mail_adres:String,
        @Field("sifre") sifre:String,
        @Field("ad_soyad") ad_soyad:String,
        @Field("telefon") telefon:String) : Call<CRUDResponse>



}