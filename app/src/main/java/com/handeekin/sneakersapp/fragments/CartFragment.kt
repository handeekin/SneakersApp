package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.CartAdapter
import com.handeekin.sneakersapp.adapterr.DiscountAdapter
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.databinding.FragmentCartBinding
import com.handeekin.sneakersapp.viewmodels.ItemsFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentItemsBinding
import com.handeekin.sneakersapp.viewmodels.CartFragmentViewModel
import com.handeekin.sneakersapp.viewmodels.DiscountFragmentViewModel
import kotlinx.android.synthetic.main.cart_card_design.*


class CartFragment : Fragment() {

    private lateinit var tasarim: FragmentCartBinding
    private lateinit var adapter: CartAdapter
    private lateinit var viewModel: CartFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_cart, container, false)
        tasarim.cartFragment = this
        viewModel.itemsAddedCart()

        viewModel.cartItemsList.observe(viewLifecycleOwner,{ cartItemsList ->
            adapter = CartAdapter(requireContext(),cartItemsList,viewModel)
            tasarim.cartAdapter = adapter
        })
        tasarim.rv.layoutManager = GridLayoutManager(context,1,GridLayoutManager.VERTICAL,false)

        tasarim.purchaseButton.setOnClickListener {
            Snackbar.make(it, "Proceeding to purchase.", Snackbar.LENGTH_LONG).show()
        }
        return tasarim.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: CartFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()
        viewModel.itemsAddedCart()

    }
}