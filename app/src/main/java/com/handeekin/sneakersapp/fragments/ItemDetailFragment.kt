package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.databinding.FragmentItemDetailBinding
import com.handeekin.sneakersapp.viewmodels.ItemDetailsFragmentViewModel
import com.handeekin.sneakersapp.viewmodels.ItemsFragmentViewModel
import com.squareup.picasso.Picasso

class ItemDetailFragment : Fragment() {

    private lateinit var tasarim : FragmentItemDetailBinding
    private lateinit var adapter: ItemsAdapter
    private lateinit var viewModel: ItemDetailsFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_item_detail, container, false)

        val b:ItemDetailFragmentArgs by navArgs()
        val recievedItem = b.nesne

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/"+"${recievedItem.itemPictureUrl}"

        Picasso.get().load(url).into(tasarim.imageView2)

        tasarim.detailObject = recievedItem
        tasarim.detailFragment = this

        tasarim.addToCartButton.setOnClickListener {
            Snackbar.make(it,"${recievedItem.itemName} sepete eklendi.", Snackbar.LENGTH_SHORT).show()
        }

        return tasarim.root
    }


}