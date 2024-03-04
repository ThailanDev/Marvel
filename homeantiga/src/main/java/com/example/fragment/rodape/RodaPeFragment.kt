package com.example.fragment.rodape

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.SwipeRefreshCustom
import com.example.homeantiga.databinding.FragmentRodaPeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RodaPeFragment : Fragment(), SwipeRefreshCustom {
    private val binding by lazy { FragmentRodaPeBinding.inflate(layoutInflater) }
    private val viewModel: RodaPeViewModel by viewModel()
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

    override fun action() {
        Log.d("setOnRefreshListener", "RodaPeFragment")
    }
    companion object {
        fun newInstance(): RodaPeFragment {
            return RodaPeFragment()
        }
    }

}