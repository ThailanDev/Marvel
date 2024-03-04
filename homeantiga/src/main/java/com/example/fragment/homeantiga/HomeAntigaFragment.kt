package com.example.fragment.homeantiga

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.BindFragment
import com.example.SwipeRefreshCustom
import com.example.SwipeRefreshCustomImpl
import com.example.activity.main.TesteActivity
import com.example.fragment.corpo.CorpoFragment
import com.example.fragment.rodape.RodaPeFragment
import com.example.fragment.topo.TopoDaHomeFragment
import com.example.homeantiga.R
import com.example.homeantiga.databinding.FragmentHomeAntigaBinding
import com.example.navigation.navigateUriWithDefaultOptions
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeAntigaFragment : BindFragment<FragmentHomeAntigaBinding>(){

    private val viewModel: HomeAntigaViewModel by viewModel ()
    val teste = object : SwipeRefreshCustom {
        override fun action() {
            Log.d("swiperbolado", "HomeAntigaFragment")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        state: Bundle?
    ): View {
        setupView()
        viewModel
        return binding.root
    }

    private fun setupView() = with(binding){
        childFragmentManager.beginTransaction()
            .replace(R.id.corpo, CorpoFragment.newInstance())
            .commit()
        childFragmentManager.beginTransaction()
            .replace(R.id.rodape, RodaPeFragment.newInstance())
            .commit()
        childFragmentManager.beginTransaction()
            .replace(R.id.topo, TopoDaHomeFragment.newInstance())
            .commit()
    }
    override fun onBind(): FragmentHomeAntigaBinding = FragmentHomeAntigaBinding.inflate(layoutInflater)

    override fun FragmentHomeAntigaBinding.onBoundView() {
        binding.homeAntigaButton.isChecked = false
        binding.homeAntigaButton.setOnClickListener {
            findNavController().navigateUriWithDefaultOptions("marvel://new_home".toUri(), isInclusive = true, popUpTo = R.id.homeAntigaFragment)
        }
        binding.profile.setOnClickListener {
//            findNavController().navigateUriWithDefaultOptions("marvel://profile".toUri(), isInclusive = true, popUpTo = R.id.homeAntigaFragment)
            startActivity(Intent(requireContext(), TesteActivity::class.java))
            requireActivity().finish()
        }

        containerSwipeRefresh.setOnRefreshListener {
            val fragmentA = childFragmentManager.findFragmentById(R.id.corpo) as? SwipeRefreshCustom
            val fragmentC = childFragmentManager.findFragmentById(R.id.rodape) as? SwipeRefreshCustom
            Log.d("setOnRefreshListener", "HomeAntigaFragment")
            fragmentA?.action()
            fragmentC?.action()
        }
    }




}