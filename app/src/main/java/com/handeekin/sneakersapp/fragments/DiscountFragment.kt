package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.DiscountAdapter
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.databinding.FragmentDiscountBinding
import com.handeekin.sneakersapp.databinding.FragmentItemsBinding
import com.handeekin.sneakersapp.viewmodels.DiscountFragmentViewModel
import com.handeekin.sneakersapp.viewmodels.ItemsFragmentViewModel

class DiscountFragment : Fragment() {

    private lateinit var tasarim: FragmentDiscountBinding
    private lateinit var adapter: DiscountAdapter
    private lateinit var viewModel: DiscountFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_discount, container, false)
        tasarim.discountFragment = this


        return tasarim.root
    }



}