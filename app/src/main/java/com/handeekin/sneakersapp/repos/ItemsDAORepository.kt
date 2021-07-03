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
    private val discountItemsList: MutableLiveData<List<ItemsClass>>
    private val cartItemsList: MutableLiveData<List<ItemsClass>>
    private val itemsdaoInterface: ItemsDAOInterface
    private var cartValidate: MutableLiveData<Int>
    private var discountValidate: MutableLiveData<Int>





    init {
        itemsdaoInterface = APIUtils.getItemsDaoInterface()
        itemsList = MutableLiveData()
        discountItemsList = MutableLiveData()
        cartItemsList = MutableLiveData()
        cartValidate = MutableLiveData()
        discountValidate = MutableLiveData()

    }

    fun getItems(): MutableLiveData<List<ItemsClass>> {
        return itemsList
    }

    fun getCartItems(): MutableLiveData<List<ItemsClass>> {
        return cartItemsList
    }

    fun getDiscountItems(): MutableLiveData<List<ItemsClass>> {
        return discountItemsList
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

    fun allProducts(){
        itemsdaoInterface.myItems("handeekin").enqueue(object : Callback<ItemsResponse> {
            override fun onResponse(call: Call<ItemsResponse?>, response: Response<ItemsResponse>) {
                val urunlerListe = response.body()!!.items
                itemsList.value = urunlerListe

                for (k in urunlerListe) {

                    Log.e("*******", "*******")
                    Log.e("mesaj", "geldi")
                    Log.e("ürün id", (k.id).toString())
                    Log.e("ürün ad", k.itemName)
                    Log.e("indirimde mi", k.issale.toString())
                    Log.e("ürün fiyat", k.itemPrice)
                }
            }
            override fun onFailure(call: Call<ItemsResponse?>, t: Throwable) {
            }
        })
    }

    fun salesItemChange(id: Int,urun_indirimli_mi :Int) {
        itemsdaoInterface.change_sales_item(id,urun_indirimli_mi).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {
             cartValidate.value = response.body()!!.success
            }
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }

    fun cartSuccess():MutableLiveData<Int>{
        return cartValidate
    }

    fun discountSuccess():MutableLiveData<Int>{
        return discountValidate
    }


    fun CartAddedItems(){
        itemsdaoInterface.myItems("handeekin").enqueue(object : Callback<ItemsResponse> {
            override fun onResponse(call: Call<ItemsResponse?>, response: Response<ItemsResponse>) {
                val urunlerListe = response.body()!!.items
                var arrayList = arrayListOf<ItemsClass>()

                for (i in urunlerListe) {

                    Log.e("*******", "*******")
                    Log.e("mesaj", "geldi")
                    Log.e("ürün id", (i.id).toString())
                    Log.e("ürün ad", i.itemName)
                    Log.e("indirimde mi", i.issale.toString())
                    Log.e("sepette mi",i.cartSituation.toString())
                    if (i.cartSituation ==1){
                        arrayList.add(i)
                    }
                    cartItemsList.value = arrayList

                }


            }
            override fun onFailure(call: Call<ItemsResponse?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    fun changeCartSit(id:Int,sepet_durum:Int) {
        itemsdaoInterface.change_cart_situation(id,sepet_durum).enqueue(object : Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {
                discountValidate.value = response.body()!!.success

            }
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }


    fun getSalesItem() {
        itemsdaoInterface.myItems("handeekin").enqueue(object : Callback<ItemsResponse?> {
            override fun onResponse(call: Call<ItemsResponse?>, response: Response<ItemsResponse?>) {
                val urunlerListe = response.body()!!.items
                var arrayList = arrayListOf<ItemsClass>()
                for (k in urunlerListe) {
                    Log.e("*******", "*******")
                    Log.e("mesaj", "geldi")
                    Log.e("ürün id", (k.id).toString())
                    Log.e("ürün ad", k.itemName)
                    Log.e("indirimde mi", k.issale.toString())
                    if (k.issale ==1){
                        arrayList.add(k)
                        Log.e("indirim",k.issale.toString())
                    }
                }
                discountItemsList.value = arrayList
            }
            override fun onFailure(call: Call<ItemsResponse?>, t: Throwable) {

                Log.e("basarız", t.localizedMessage.toString())

            }
        })
    }




}