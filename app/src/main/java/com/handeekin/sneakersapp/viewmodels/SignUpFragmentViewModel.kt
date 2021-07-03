package com.handeekin.sneakersapp.viewmodels

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.entityy.UsersClass
import com.handeekin.sneakersapp.repos.UserDAORepository


class SignUpFragmentViewModel : ViewModel() {

    private val udaoi = UserDAORepository()





    fun signup(mail_adres:String,sifre:String,ad_soyad:String,telefon:String) {
        Log.e("User signed up","$mail_adres - $sifre - $ad_soyad - $telefon")
        udaoi.addUser(mail_adres,sifre,ad_soyad,telefon)
    }

}