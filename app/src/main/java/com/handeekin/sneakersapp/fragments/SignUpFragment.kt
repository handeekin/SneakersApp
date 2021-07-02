package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.databinding.FragmentSignUpBinding
import com.handeekin.sneakersapp.viewmodels.SignUpFragmentViewModel


class SignUpFragment : Fragment() {

    private lateinit var tasarim:FragmentSignUpBinding
    private lateinit var viewModel: SignUpFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        tasarim.signUpFragment = this

        return tasarim.root



    }

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : SignUpFragmentViewModel by viewModels()
       this.viewModel = tempViewModel
    }


    fun signUpButtonClicked(mail_adres:String,sifre:String,ad_soyad:String,telefon:String){
        viewModel.signup(mail_adres, sifre, ad_soyad, telefon)
    }

}