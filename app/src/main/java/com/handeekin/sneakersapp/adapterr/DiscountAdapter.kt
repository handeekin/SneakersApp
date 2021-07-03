package com.handeekin.sneakersapp.adapterr

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.databinding.CardDesignBinding
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.fragments.DiscountFragmentDirections
import com.handeekin.sneakersapp.fragments.ItemsFragmentDirections
import com.squareup.picasso.Picasso

class DiscountAdapter(var mContext: Context,
                      var salesItemsList: List<ItemsClass> )
    : RecyclerView.Adapter<DiscountAdapter.CardDesignHolder>() {


    inner class CardDesignHolder(cardTasarimBinding: CardDesignBinding)
        : RecyclerView.ViewHolder(cardTasarimBinding.root){

        var cardDesignBinding: CardDesignBinding

        init {
            this.cardDesignBinding = cardTasarimBinding
        }
    }

    override fun getItemCount(): Int {
        return salesItemsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountAdapter.CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(tasarim)
    }


    //görsel nesneleri burda yönetcez tıklama falan
    override fun onBindViewHolder(holder: DiscountAdapter.CardDesignHolder, position: Int) {
        val item = salesItemsList.get(position)

        val product = salesItemsList.get(position)
        val url = product.itemPictureUrl

        Picasso.get().load(url).into(holder.cardDesignBinding.imageView)

        var discount= listOf<String>("1,899.90 TL","1,899.90 TL","1,989.90 TL")
        holder.cardDesignBinding.textViewTotalPrice.apply {
            paintFlags= paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        holder.cardDesignBinding.discountText.text = discount[position].toString()
        val t = holder.cardDesignBinding
        t.itemObject = item



        t.addToCartButton.setOnClickListener {
            Snackbar.make(it,"${item.itemName} sepete eklendi.", Snackbar.LENGTH_SHORT).show()
        }


        t.cardView.setOnClickListener {

            val gecis = DiscountFragmentDirections.discountDetayGecis(item)

            Navigation.findNavController(it).navigate(gecis)
        }



    }}
