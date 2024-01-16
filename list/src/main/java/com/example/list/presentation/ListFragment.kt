package com.example.list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.core_android.error.ScreenOfErrorFragment
import com.example.core_android.network.api.model.characters.Character
import com.example.list.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val viewModel: ListViewModel by viewModel()
    private val adapter by lazy { ListAdapter() }
    private lateinit var dialogFragment: ScreenOfErrorFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        observer()

        // Inicializar o Cast SDK

        // Adicionar botão de transmissão à barra de ação
//        CastButtonFactory.setUpMediaRouteButton(requireContext(), menu, R.id.media_route_menu_item)

        return binding.root
    }

    private fun observer() {
        viewModel.state.observe(viewLifecycleOwner) {
            isLoading(it.isLoading)
            isListEmpty(it.isLoading, it.data?.characterDataContainer?.character.isNullOrEmpty())
            setupAdapter(it.data?.characterDataContainer?.character)
        }
    }

    private fun isListEmpty(isLoading: Boolean, nullOrEmpty: Boolean) {
//        if (!isLoading && nullOrEmpty) {
//            dialogFragment = ScreenOfErrorFragment()
//            dialogFragment.show(childFragmentManager, "MyFragment")
//            dialogFragment.retryLoading(::retryLoading)
//        }
    }

    private fun retryLoading(){

    }

    private fun setupAdapter(character: List<Character>?) {
        adapter.listItems = character
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recycler.adapter = adapter
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading) binding.shimmer.startShimmer() else {
            binding.shimmer.stopShimmer()
            binding.shimmer.isVisible = false
        }
    }

    private fun navigateToDetails() {
    }

}