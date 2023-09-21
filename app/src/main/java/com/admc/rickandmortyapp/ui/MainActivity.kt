package com.admc.rickandmortyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.admc.rickandmortyapp.R
import com.admc.rickandmortyapp.databinding.ActivityMainBinding
import com.admc.rickandmortyapp.ui.adapter.RickMortyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RickMortyAdapter
    private val charactersViewModel: RickMortyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        charactersViewModel.getCharacters()
        initRecyclerView()
        charactersViewModel.errorMessage.observe(this, Observer {message->
            if (message.isNotEmpty()){
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        binding.rvCharacter.layoutManager = manager
        charactersViewModel.charactersList.observe(this, Observer { characters ->
            adapter = RickMortyAdapter(characters)
            binding.rvCharacter.adapter = adapter
        })
    }
}