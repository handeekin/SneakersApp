package com.handeekin.sneakersapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.entityy.UsersClass

import com.handeekin.sneakersapp.repos.UserDAORepository



class OpeningFragmentViewModel : ViewModel() {

    private val udaoi = UserDAORepository()
    var success = MutableLiveData<Int>()
    var user = MutableLiveData<List<UsersClass>>()

  /*  init {
        login()
        user = udaoi.getUserVal()
    }*/


    fun login(mail_adres:String, sifre:String) {
        Log.e("User signed up","$mail_adres - $sifre")
        udaoi.getUser(mail_adres,sifre)
        }


}