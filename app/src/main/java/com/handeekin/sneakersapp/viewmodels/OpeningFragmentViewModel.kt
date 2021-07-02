package com.handeekin.sneakersapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

import com.handeekin.sneakersapp.repos.UserDAORepository



class OpeningFragmentViewModel : ViewModel() {

    private val udaoi = UserDAORepository()

    fun login(mail_adres:String, sifre:String) {
        Log.e("User signed up","$mail_adres - $sifre")
        udaoi.getUser(mail_adres,sifre)
        }


}