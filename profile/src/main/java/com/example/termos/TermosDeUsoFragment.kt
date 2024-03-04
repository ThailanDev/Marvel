package com.example.termos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.navigation.navigateUriWithDefaultOptions
import com.example.profile.databinding.FragmentTermosDeUsoBinding
import org.koin.core.component.getScopeName

class TermosDeUsoFragment : Fragment() {

    private val binding by lazy { FragmentTermosDeUsoBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBackStack()
      binding.irParaDetalhes.setOnClickListener {
          findNavController().navigateUriWithDefaultOptions("marvel://details".toUri())
      }
        return binding.root
    }

    private fun listBackStack(){
        Log.d("TAG", "------------TERMOS------------")
        val navigate = findNavController().currentBackStack.value
        navigate.forEach {
            Log.d("TAG", "${it.destination}")
        }
        Log.d("TAG", "------------------------")
    }


}