package com.handeekin.sneakersapp.Repo

import androidx.lifecycle.MutableLiveData
import com.handeekin.sneakersapp.Entity.*
import com.handeekin.sneakersapp.Retrofit.APIUtils
import com.handeekin.sneakersapp.Retrofit.ItemsUsersDAOInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field

class ItemsUsersDAORepository {

    private val itemsList: MutableLiveData<List<ItemsClass>>
    private val itemsusersdaoInterface: ItemsUsersDAOInterface

    init {
        itemsusersdaoInterface = APIUtils.getItemsDaoInterface()
        itemsList = MutableLiveData()
    }

    fun itemAdd(satici_adi:String, urun_adi:String, urun_fiyat:String, urun_aciklama:String, urun_gorsel_url:String) {
        itemsusersdaoInterface.addItem(satici_adi, urun_adi, urun_fiyat, urun_aciklama, urun_gorsel_url).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {}
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun salesItemChange(id: Int,urun_indirimli_mi :Int) {
       itemsusersdaoInterface.change_sales_item(id,urun_indirimli_mi).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {}
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun changeCartSit(id:Int,sepet_durum:Int) {
        itemsusersdaoInterface.change_cart_situation(id,sepet_durum).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {}
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun items(satici_adi: String) {
        itemsusersdaoInterface.allItems(satici_adi).enqueue(object : Callback<ItemsResponse?> {
            override fun onResponse(call: Call<ItemsResponse?>, response: Response<ItemsResponse?>) {}
            override fun onFailure(call: Call<ItemsResponse?>, t: Throwable) {}
        })
    }

    fun signup(mail_adres:String, sifre:String,ad_soyad:String,telefon:String) {
        itemsusersdaoInterface.signUp(mail_adres, sifre,ad_soyad,telefon).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {}
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun login(mail_adres:String, sifre:String) {
        itemsusersdaoInterface.login(mail_adres, sifre).enqueue(object : Callback<UsersResponse?> {
            override fun onResponse(call: Call<UsersResponse?>, response: Response<UsersResponse?>) {}
            override fun onFailure(call: Call<UsersResponse?>, t: Throwable) {}
        })
    }

}