package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.databinding.FragmentItemDetailBinding
import com.handeekin.sneakersapp.viewmodels.DiscountFragmentViewModel
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
        tasarim.detailObject = recievedItem
        tasarim.detailFragment = this

        val image = tasarim.imageView2
        Picasso.get().load(recievedItem.itemPictureUrl).into(image)


        tasarim.addToCartButton.setOnClickListener {
            Snackbar.make(it,"${recievedItem.itemName} sepete eklendi.", Snackbar.LENGTH_SHORT).show()
        }

        return tasarim.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}