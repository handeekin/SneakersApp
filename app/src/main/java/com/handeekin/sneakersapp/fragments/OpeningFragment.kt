package com.handeekin.sneakersapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.MainActivity
import com.handeekin.sneakersapp.R

import com.handeekin.sneakersapp.viewmodels.OpeningFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentOpeningBinding
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.UsersDAOInterface


class OpeningFragment : Fragment() {

    private lateinit var udaoi: UsersDAOInterface
    private lateinit var tasarim:FragmentOpeningBinding
    private lateinit var viewModel: OpeningFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        udaoi = APIUtils.getUsersDaoInterface()
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_opening, container, false)
        tasarim.openingFragment = this

        tasarim.openingLoginButton.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.itemsGecis)
        }

        viewModel.user.observe(viewLifecycleOwner){
            if (it[0].user_val == 1){
                Navigation.findNavController(requireView()).navigate(R.id.itemsGecis)
            }
            else{
                Snackbar.make(requireView(),"Wrong e-mail or password.",Snackbar.LENGTH_SHORT).show()
            }

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun buttonLoginClicked(mail_adres:String,sifre:String){
        viewModel.login(mail_adres,sifre)

        }
    }





