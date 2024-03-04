package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindFragment<Binding : ViewDataBinding> : Fragment() {
    private var _binding: Binding? = null
    val binding: Binding
        get() = _binding ?: {
            _binding = onBind()
            _binding!!
        }()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: Bundle?
    ): View? = binding.root
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.onBoundView()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    abstract fun onBind() : Binding
    abstract fun Binding.onBoundView()
}