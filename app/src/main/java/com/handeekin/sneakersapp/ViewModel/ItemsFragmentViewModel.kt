package com.handeekin.sneakersapp.ViewModel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.Entity.ItemsClass
import com.handeekin.sneakersapp.Entity.ItemsResponse
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.Repo.ItemsUsersDAORepository
import com.handeekin.sneakersapp.Retrofit.APIUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemsFragmentViewModel : ViewModel() {

    var itemsList = MutableLiveData<List<ItemsClass>>()


    private val iudaoi = ItemsUsersDAORepository()



    fun GetItems(){


        iudaoi.items("handeekin").enqueue(object : Callback<ItemsResponse> {

            override fun onResponse(call: Call<ItemsResponse>?, response: Response<ItemsResponse>?) {

                if(response != null){

                    val ItemList = response.body().id

                    for(k in ItemList){

                        Log.e("*******","*******")
                        Log.e("satıcı adı",(k.satici_id))
                        Log.e("ürün fiyat",k.urun_fiyat)

                    }

                }

            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {

            }

        })

    }


}