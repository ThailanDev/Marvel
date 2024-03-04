package com.example.homenova

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.example.homenova.databinding.FragmentHomeNovaBinding
import com.example.navigation.navigateUriWithDefaultOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeNovaFragment : Fragment() {
    private val viewModel:HomeNovaViewModel by viewModel()
    private val binding by lazy { FragmentHomeNovaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.teste()
        binding.homeNovaButton.isChecked = true
        binding.homeNovaButton.setOnClickListener {
            findNavController().navigateUriWithDefaultOptions("marvel://old_home".toUri(), isInclusive = true, popUpTo = R.id.graph_new_home)
        }
        binding.profile.setOnClickListener {
            findNavController().navigateUriWithDefaultOptions("marvel://profile".toUri(), popUpTo = R.id.telaIntermediariaFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "onDestroyView: home nova")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroyView: home nova")
    }

}