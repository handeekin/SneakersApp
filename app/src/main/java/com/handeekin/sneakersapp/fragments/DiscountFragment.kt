package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
        tasarim.RecyclerView.layoutManager = StaggeredGridLayoutManager(1,
            StaggeredGridLayoutManager.VERTICAL)

        viewModel.salesitemsList.observe(viewLifecycleOwner) {
            Log.e("indirim fragment", it[0].itemName)
            adapter = DiscountAdapter(requireContext(),it,viewModel)
            tasarim.discountAdapter = adapter
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: DiscountFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }



}