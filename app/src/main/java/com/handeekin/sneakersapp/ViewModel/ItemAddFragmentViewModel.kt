package com.handeekin.sneakersapp.ViewModel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.Repo.ItemsUsersDAORepository


class ItemAddFragmentViewModel : ViewModel() {

    private val iudaoi = ItemsUsersDAORepository()

    fun addItem(satici_adi:String, urun_adi:String, urun_fiyat:String, urun_aciklama:String, urun_gorsel_url:String) {
        Log.e("Item Added","$satici_adi - $urun_adi - $urun_fiyat - $urun_aciklama - $urun_gorsel_url")
        iudaoi.itemAdd(satici_adi, urun_adi, urun_fiyat, urun_aciklama, urun_gorsel_url)
    }
}