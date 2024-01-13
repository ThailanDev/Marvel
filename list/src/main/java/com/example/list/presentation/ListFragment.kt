package com.example.list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import com.example.core_android.network.api.model.characters.Character
import com.example.list.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val viewModel: ListViewModel by viewModel()
    private val adapter by lazy { ListAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        observer()
//        Glide.with(this)
//            .load("https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg")
//            .into(binding.imageView);
        return binding.root
    }

    private fun observer() {
        viewModel.state.observe(viewLifecycleOwner) {
            isLoading(it.isLoading)
            setupAdapter(it.data?.characterDataContainer?.character)
        }
    }

    private fun setupAdapter(character: List<Character>?) {
        adapter.listItems = character
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recycler.adapter = adapter
    }

    private fun isLoading(isLoading:Boolean) {
        if(isLoading) binding.shimmer.startShimmer() else {
            binding.shimmer.stopShimmer()
            binding.shimmer.isVisible = false
        }
    }

    private fun navigateToDetails(){
    }

}