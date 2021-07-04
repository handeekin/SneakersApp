package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.databinding.FragmentUserInfoBinding


class UserInfoFragment : Fragment() {

    private lateinit var tasarim:FragmentUserInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_user_info, container, false)

        //loadData()


        return tasarim.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /*private fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val savedStringName = sharedPreferences.getString("STRING_NAME",null)
        val savedStringMail = sharedPreferences.getString("STRING_MAIL",null)
        val savedStringPhone = sharedPreferences.getString("STRING_PHONE",null)
        textinfoNameSurname.text = savedStringName
        textinfoMail.text = savedStringMail
        textinfoPhoneNumber.text = savedStringPhone
    }*/


}