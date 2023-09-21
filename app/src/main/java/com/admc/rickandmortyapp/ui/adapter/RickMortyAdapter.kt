package com.admc.rickandmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admc.rickandmortyapp.R
import com.admc.rickandmortyapp.data.model.Characters
import com.admc.rickandmortyapp.data.model.Result

class RickMortyAdapter(private val characters: List<Result>):RecyclerView.Adapter<RickMortyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return RickMortyViewHolder(layoutInflater.inflate(R.layout.item_rm,parent,false))
    }

    override fun getItemCount(): Int = characters.size
    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
       val item = characters[position]
        holder.bind(item)
    }

}