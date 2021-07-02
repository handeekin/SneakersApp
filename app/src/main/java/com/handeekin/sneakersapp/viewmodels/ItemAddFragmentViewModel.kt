package com.handeekin.sneakersapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.repos.ItemsDAORepository



class ItemAddFragmentViewModel : ViewModel() {

    private val idaoi = ItemsDAORepository()

    fun addItem(satici_adi:String, urun_adi:String, urun_fiyat:String, urun_aciklama:String, urun_gorsel_url:String) {
        Log.e("Item Added","$satici_adi - $urun_adi - $urun_fiyat - $urun_aciklama - $urun_gorsel_url")
        idaoi.itemAdd(satici_adi, urun_adi, urun_fiyat, urun_aciklama, urun_gorsel_url)
    }


}