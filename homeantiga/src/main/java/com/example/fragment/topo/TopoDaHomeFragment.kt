package com.example.fragment.topo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.homeantiga.StatusDasRequisiCoes
import com.example.homeantiga.databinding.FragmentTopDaHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopoDaHomeFragment(
) : Fragment() {
    private val binding by lazy { FragmentTopDaHomeBinding.inflate(layoutInflater) }
    private val viewModel: TopoDaHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel
        return binding.root
    }

    companion object {
        fun newInstance(): TopoDaHomeFragment {
return TopoDaHomeFragment()
        }
    }

}