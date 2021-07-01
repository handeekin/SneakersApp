package com.handeekin.sneakersapp.Fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.handeekin.sneakersapp.R


class CartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val design = DataBindingUtil.inflate(inflater.R.layout.fragment_cart, container, false)

        (activity as AppCompatActivity).setSupportActionBar(design.findViewById(R.id.toolbar))

        return design
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}