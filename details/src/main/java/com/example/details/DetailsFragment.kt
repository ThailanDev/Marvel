package com.example.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.details.databinding.FragmentDetailsBinding
import com.example.navigation.navigateUriWithDefaultOptions
import org.koin.core.component.getScopeName

class DetailsFragment : Fragment() {

    private val binding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

}