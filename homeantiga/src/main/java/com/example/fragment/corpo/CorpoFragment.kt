package com.example.fragment.corpo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.SwipeRefreshCustom
import com.example.SwipeRefreshCustomImpl
import com.example.homeantiga.databinding.FragmentCorpoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CorpoFragment() : Fragment(), SwipeRefreshCustom{

    private val viewModel: CorpoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val binding by lazy { FragmentCorpoBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    companion object {
        fun newInstance(): CorpoFragment {
            return CorpoFragment()
        }
    }

    override fun action() {
        Log.d("setOnRefreshListener", "CorpoFragment")
    }
}

