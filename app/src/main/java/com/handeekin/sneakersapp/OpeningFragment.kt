package com.handeekin.sneakersapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.handeekin.sneakersapp.Retrofit.ItemsUsersDAOInterface
import com.handeekin.sneakersapp.ViewModel.OpeningFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentOpeningBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OpeningFragment : Fragment() {

    private lateinit var tasarim:FragmentOpeningBinding
    private lateinit var viewModel: OpeningFragmentViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_opening,container,false)

        tasarim.








        return tasarim.root



       /* fun SignUp(mail_adres:String,sifre:String,ad_soyad:String,telefon:String){

          ItemsUsersDAOInterface.signUp("")

        }
*/
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment içinde viewModel tanımlaması
        val tempViewModel: OpeningFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    fun buttonLoginClicked(mail_adres:String,sifre:String){
        viewModel.login(mail_adres,sifre)
    }


    fun SignUp(mail_adres:String,sifre:String,ad_soyad:String,telefon:String){

        viewModel.signup(mail_adres,sifre,ad_soyad,telefon)
    }


}