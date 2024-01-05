package com.example.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        viewModel.getList()
        return binding.root
    }
}