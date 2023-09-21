package com.admc.rickandmortyapp.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.admc.rickandmortyapp.data.model.Result
import com.admc.rickandmortyapp.databinding.ItemRmBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class RickMortyViewHolder(view: View):ViewHolder(view) {
    private var binding = ItemRmBinding.bind(view)
    fun bind(result:Result){
        binding.tvCharacter.text = result.name
      Picasso.get().load(result.image).into(binding.ivCharacter)
    }


}