package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.viewmodels.ItemsFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentItemsBinding


class CartFragment : Fragment() {

    private lateinit var tasarim: FragmentItemsBinding
    private lateinit var adapter: ItemsAdapter
    private lateinit var viewModel: ItemsFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim = DataBindingUtil.inflate(inflater, R.id.cartFragment, container, false)


        return tasarim.root


    }
}