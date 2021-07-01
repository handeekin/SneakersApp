package com.handeekin.sneakersapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.handeekin.sneakersapp.R

class ItemsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)



    }

    fun fabTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.ItemAddGecis)
    }


}