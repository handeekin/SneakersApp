package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.databinding.FragmentSignUpBinding
import com.handeekin.sneakersapp.viewmodels.SignUpFragmentViewModel
import com.squareup.picasso.Picasso


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




       tasarim.backtoLogin.setOnClickListener {
            val gecis = SignUpFragmentDirections.signuptologingecis()
            Navigation.findNavController(it).navigate(gecis)
        }
        tasarim.signUpButton.setOnClickListener {
            val gecis = SignUpFragmentDirections.signuptologingecis()
            Navigation.findNavController(it).navigate(gecis)
        }

        return tasarim.root




    }

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : SignUpFragmentViewModel by viewModels()
       this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    fun signUpButtonClicked(mail_adres:String,sifre:String,ad_soyad:String,telefon:String){
        viewModel.signup(mail_adres, sifre, ad_soyad, telefon)
    }

}