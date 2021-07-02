package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.viewmodels.ItemsFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentItemsBinding

class ItemsFragment : Fragment() {

    private lateinit var tasarim:FragmentItemsBinding
    private lateinit var adapter: ItemsAdapter
    private lateinit var viewModel: ItemsFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_items, container, false)
        tasarim.itemsFragment = this
        tasarim.RecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        viewModel.itemsList.observe(viewLifecycleOwner) {
            adapter = ItemsAdapter(requireContext(), it)
            tasarim.itemsAdapter = adapter
        }


        return tasarim.root



    }

    fun fabTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.ItemAddGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        //Fragment içinde viewModel tanımlaması
        val tempViewModel: ItemsFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

/*    override fun onResume() {
        super.onResume()
        //Sayfaya geri geldiğinde verileri yükle
        viewModel.showMyItems()
    }*/


}