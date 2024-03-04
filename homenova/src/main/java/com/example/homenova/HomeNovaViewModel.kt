package com.example.homenova

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class HomeNovaViewModel(
) : ViewModel() {
    init {
        Log.d("TAG", "init viewmodel home nova: ")
    }
    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "onCleared viewModel home nova")
    }

    private fun setupeLaunch(){

    }

    fun teste() {
    }
}