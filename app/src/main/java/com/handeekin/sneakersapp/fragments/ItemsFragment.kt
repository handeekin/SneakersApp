package com.handeekin.sneakersapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.handeekin.sneakersapp.R
import com.handeekin.sneakersapp.adapterr.ItemsAdapter
import com.handeekin.sneakersapp.viewmodels.ItemsFragmentViewModel
import com.handeekin.sneakersapp.databinding.FragmentItemsBinding
import com.handeekin.sneakersapp.repos.ItemsDAORepository

class ItemsFragment : Fragment() {
    private lateinit var tasarim:FragmentItemsBinding
    private lateinit var adapter: ItemsAdapter
    private lateinit var viewModel: ItemsFragmentViewModel
    private lateinit var idaor:ItemsDAORepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_items, container, false)
        tasarim.itemsFragment = this
        tasarim.RecyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        viewModel.itemsList.observe(viewLifecycleOwner) {
            adapter = ItemsAdapter(requireContext(), it,viewModel)
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
        val tempViewModel: ItemsFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_cart -> {
                Navigation.findNavController(requireView()).navigate(R.id.itemtocartGecis)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

}