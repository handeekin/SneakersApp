package com.handeekin.sneakersapp.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.ItemsDAOInterface
import com.handeekin.sneakersapp.entityy.CRUDResponse
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.entityy.ItemsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsDAORepository {

    private val itemsList: MutableLiveData<List<ItemsClass>>
    private val itemsdaoInterface: ItemsDAOInterface



    init {
        itemsdaoInterface = APIUtils.getItemsDaoInterface()
        itemsList = MutableLiveData()
    }

    fun getItems(): MutableLiveData<List<ItemsClass>> {
        return itemsList
    }

    fun itemAdd(satici_adi:String, urun_adi:String, urun_fiyat:String, urun_aciklama:String, urun_gorsel_url:String) {
        itemsdaoInterface.addItem(satici_adi, urun_adi, urun_fiyat, urun_aciklama, urun_gorsel_url).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {
            }
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {
                Log.e("hata",t.localizedMessage.toString())
            }
        })
    }

    fun salesItemChange(id: Int,urun_indirimli_mi :Int) {
        itemsdaoInterface.change_sales_item(id,urun_indirimli_mi).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {
                Log.e("response",response.body()!!.success.toString())
                Log.e("mesaj",response.body()!!.message)
            }
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }
    fun getSalesItem(urun_indirimli_mi :Int,urun_adi:String, urun_fiyat:String, urun_aciklama:String, urun_gorsel_url:String) {
        itemsdaoInterface.get_sales_item(urun_indirimli_mi = 1, urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {
                Log.e("response",response.body()!!.success.toString())
                Log.e("mesaj",response.body()!!.message)
            }
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun changeCartSit(id:Int,sepet_durum:Int) {
        itemsdaoInterface.change_cart_situation(id,sepet_durum).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {}
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun allProducts(){
        itemsdaoInterface.myItems("handeekin").enqueue(object : Callback<ItemsResponse> {
            override fun onResponse(call: Call<ItemsResponse?>, response: Response<ItemsResponse>) {
                val urunlerListe = response.body()!!.items

                for (k in urunlerListe) {

                    Log.e("*******", "*******")
                    Log.e("mesaj", "geldi")
                    Log.e("ürün id", (k.id).toString())
                    Log.e("ürün ad", k.itemName)
                    Log.e("indirimde mi", k.issale.toString())

                }

            }
            override fun onFailure(call: Call<ItemsResponse?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


   /* fun findSeller(satici_adi:String) {
        itemsdaoInterface.myItems(satici_adi).enqueue(object : Callback<ItemsResponse> {
            override fun onResponse(call: Call<ItemsResponse>, response: Response<ItemsResponse>) {
                val liste = response.body()!!.items
                itemsList.value = liste
            }
            override fun onFailure(call: Call<ItemsResponse>, t: Throwable) {}
        })
    }*/


}