package com.handeekin.sneakersapp.adapterr

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.databinding.CardDesignBinding
import com.handeekin.sneakersapp.databinding.CartCardDesignBinding
import com.handeekin.sneakersapp.entityy.ItemsClass
import com.handeekin.sneakersapp.fragments.CartFragmentDirections
import com.handeekin.sneakersapp.fragments.DiscountFragmentDirections
import com.handeekin.sneakersapp.viewmodels.CartFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cart_card_design.*

class CartAdapter(var mContext: Context,
                  var cartItemsList: List<ItemsClass>,
                  var viewModel : CartFragmentViewModel)
    : RecyclerView.Adapter<CartAdapter.CartCardDesignHolder>() {

    inner class CartCardDesignHolder(cartCardDesignBinding: CartCardDesignBinding)
        : RecyclerView.ViewHolder(cartCardDesignBinding.root){
        var cartCardDesignBinding: CartCardDesignBinding

        init {
            this.cartCardDesignBinding = cartCardDesignBinding
        }
    }

    override fun getItemCount(): Int {
        return cartItemsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CartCardDesignBinding.inflate(layoutInflater,parent,false)
        return CartCardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CartCardDesignHolder, position: Int) {
        val item = cartItemsList.get(position)
        holder.cartCardDesignBinding.cartObject=item
        val product = cartItemsList.get(position)
        val url = product.itemPictureUrl
        Picasso.get().load(url).into(holder.cartCardDesignBinding.imageViewCart)
        val t = holder.cartCardDesignBinding
        t.cartObject = item

        t.deleteButton.setOnClickListener {
            viewModel.itemsDeletedCart(item.id,sepet_durum = 0)
            viewModel.itemsAddedCart()
            Snackbar.make(it,"${item.itemName} is deleted from your cart.", Snackbar.LENGTH_LONG).show()
            //sayfayı yeniletmek istiyorum
        }
        t.cardView.setOnClickListener {
            val gecis = CartFragmentDirections.cartToDetailgecis(item)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.detailsButton.setOnClickListener {
            val gecis = CartFragmentDirections.cartToDetailgecis(item)
            Navigation.findNavController(it).navigate(gecis)
        }



    }

}
