package com.handeekin.sneakersapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.handeekin.sneakersapp.MainActivity
import com.handeekin.sneakersapp.R

import com.handeekin.sneakersapp.viewmodels.OpeningFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentOpeningBinding


class OpeningFragment : Fragment() {

    private lateinit var tasarim:FragmentOpeningBinding
    private lateinit var viewModel: OpeningFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_opening, container, false)
        tasarim.openingFragment = this

        tasarim.openingLoginButton.setOnClickListener {


            Navigation.findNavController(it).navigate(R.id.itemsGecis)
        }


        tasarim.openingSignupButton.setOnClickListener {


          Navigation.findNavController(it).navigate(R.id.SignUpGecis)

        }




        return tasarim.root

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment içinde viewModel tanımlaması
        val tempViewModel: OpeningFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    fun buttonLoginClicked(mail_adres:String,sifre:String){
        viewModel.login(mail_adres,sifre)
      /*  viewModel.success.observe(viewLifecycleOwner,{
            println(it)
            if (it ==1)
                val intent = Intent(getActivity(),MainActivity::class.java)
            getActivity()?.startActivity(intent)
            viewModel.user.observe(viewLifecycleOwner, {})
        })*/
    }





}