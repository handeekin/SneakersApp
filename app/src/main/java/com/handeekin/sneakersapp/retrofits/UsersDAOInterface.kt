package com.handeekin.sneakersapp.retrofits

import com.handeekin.sneakersapp.entityy.CRUDResponse
import com.handeekin.sneakersapp.entityy.UsersResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersDAOInterface {


    @POST("giris_yap.php")
    @FormUrlEncoded
    fun logIn(
        @Field("mail_adres") mail_adres:String,
        @Field("sifre") sifre:String): Call<UsersResponse>


    @POST("uye_ol.php")
    @FormUrlEncoded
    fun signUp(
        @Field("mail_adres") mail_adres:String,
        @Field("sifre") sifre:String,
        @Field("ad_soyad") ad_soyad:String,
        @Field("telefon") telefon:String) : Call<CRUDResponse>

    @GET("giris_yap.php")
    @FormUrlEncoded
    fun getId(
        @Field("deger") deger:Int) : Call<UsersResponse>
    
}