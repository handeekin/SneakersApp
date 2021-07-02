package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.viewmodels.ItemAddFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentItemAddingBinding

class ItemAddingFragment : Fragment() {



    private lateinit var tasarim:FragmentItemAddingBinding
    private lateinit var viewModel: ItemAddFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_item_adding, container, false)
        tasarim.itemAddingFragment = this

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment içinde viewModel tanımlaması
        val tempViewModel: ItemAddFragmentViewModel by viewModels()
        this.viewModel = tempViewModel

    }

    fun addItemClicked(satici_adi:String, urun_adi:String, urun_fiyat:String, urun_aciklama:String, urun_gorsel_url:String){
        viewModel.addItem(satici_adi, urun_adi, urun_fiyat, urun_aciklama, urun_gorsel_url)
    }



}