package com.handeekin.sneakersapp.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.databinding.FragmentSignUpBinding
import com.handeekin.sneakersapp.viewmodels.SignUpFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class SignUpFragment : Fragment() {

    private lateinit var tasarim:FragmentSignUpBinding
    private lateinit var viewModel: SignUpFragmentViewModel
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        tasarim.signUpFragment = this

        sharedPreferences = requireContext().getSharedPreferences("Shared_pref", Context.MODE_PRIVATE)



       tasarim.backtoLogin.setOnClickListener {
            val gecis = SignUpFragmentDirections.signuptologingecis()
            Navigation.findNavController(it).navigate(gecis)
        }

        tasarim.signUpButton.setOnClickListener {
            val name : String = tasarim.editTextNameSurnamef.text.toString()
            val phone : String =tasarim.editTextPhoneNumberf.text.toString()
            val mail : String = tasarim.editTextEmailSignf.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putString("PHONE",phone)
            editor.putString("MAIL",mail)
            editor.apply()

            Toast.makeText(requireContext(),"Succesfully signed up!",Toast.LENGTH_SHORT).show()

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