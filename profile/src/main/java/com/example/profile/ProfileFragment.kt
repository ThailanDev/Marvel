package com.example.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.navigation.navigateUriWithDefaultOptions
import com.example.profile.databinding.FragmentProfileBinding
import org.koin.core.component.getScopeName

class ProfileFragment : Fragment() {

    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBackStack()

       binding.close.setOnClickListener {
          findNavController().navigateUp()
       }
        return binding.root
    }

    private fun listBackStack(){
        Log.d("TAG", "------------PROFILE------------")
        val navigate = findNavController().currentBackStack.value
        navigate.forEach {
            Log.d("TAG", "${it.destination}")
        }
        Log.d("TAG", "------------------------")
    }

}