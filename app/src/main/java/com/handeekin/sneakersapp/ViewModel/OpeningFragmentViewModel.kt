package com.handeekin.sneakersapp.ViewModel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.handeekin.sneakersapp.Entity.UsersResponse
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.Repo.ItemsUsersDAORepository
import com.handeekin.sneakersapp.Retrofit.ItemsUsersDAOInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OpeningFragmentViewModel : ViewModel() {

    private val iudaoi = ItemsUsersDAORepository()

    fun login(mail_adres:String, sifre:String) {
        Log.e("User signed up","$mail_adres - $sifre")
        iudaoi.login(mail_adres,sifre)
        }

    fun signup(mail_adres:String,sifre:String,ad_soyad:String,telefon:String) {
        Log.e("User signed up","$mail_adres - $sifre - $ad_soyad - $telefon")
        iudaoi.signup(mail_adres,sifre,ad_soyad,telefon)
        }
}