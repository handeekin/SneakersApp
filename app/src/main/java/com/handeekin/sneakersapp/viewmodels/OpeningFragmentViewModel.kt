package com.handeekin.sneakersapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.entityy.UsersClass

import com.handeekin.sneakersapp.repos.UserDAORepository



class OpeningFragmentViewModel : ViewModel() {

    val udaor = UserDAORepository()
    var success = MutableLiveData<Int>()
    var user = MutableLiveData<List<UsersClass>>()

   init {
        user = udaor.userValidation()
    }


    fun login(mail_adres:String, sifre:String) {
        Log.e("User signed up","$mail_adres - $sifre")
        udaor.getUser(mail_adres,sifre)
        }


}