package com.example.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.list.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val viewModel: ListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        observer()
        return binding.root
    }

    private fun observer() {
        viewModel.state.observe(viewLifecycleOwner) {
            Log.d("TAG", "observer: ${it}")
        }
    }

}