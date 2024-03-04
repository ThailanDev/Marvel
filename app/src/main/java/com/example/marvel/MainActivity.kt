package com.example.marvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.marvel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val showStories = true
    val showNewHome = false


    private val navController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigate()
//        if(showNewHome && showStories) {
//            setStartDestination(R.id.homeNovaAppFragment)
//        } else {
//            setStartDestination(R.id.homeAntigaAppFragment)
//        }
    }

    private fun setStartDestination(startDestination: Int) {
        val navGraph = navController.navInflater.inflate(R.navigation.app_nav_graph)
        navGraph.setStartDestination(R.id.homeNovaAppFragment)
        navController.graph = navGraph
    }
    private fun setupNavigate() = with(binding) {
        val navController = navController
        navigation.setupWithNavController(navController)
    }
}