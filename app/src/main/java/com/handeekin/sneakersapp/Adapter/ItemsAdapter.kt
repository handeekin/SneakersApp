package com.handeekin.sneakersapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.handeekin.sneakersapp.Entity.ItemsClass
import com.handeekin.sneakersapp.ItemsFragmentDirections
import com.handeekin.sneakersapp.ViewModel.ItemsFragmentViewModel
import com.handeekin.sneakersapp.databinding.CardDesignBinding

class ItemsAdapter(var mContext: Context, var itemsList: List<ItemsClass>, var viewModel: ItemsFragmentViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class CardDesignHolder(cardDesignBinding: CardDesignBinding)
        :RecyclerView.ViewHolder(cardDesignBinding.root){

        var cardDesignBinding:CardDesignBinding

        init {
            this.cardDesignBinding = cardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val item = itemsList.get(position)
        val t = holder.cardDesignBinding

        t.itemObject = item

        t.cardView.setOnClickListener {

            val gecis = ItemsFragmentDirections.itemAddGecis(item)

            Navigation.findNavController(it).navigate(gecis)
        }


    }

    override fun getItemCount(): Int {
        return itemsList.size
    }



}