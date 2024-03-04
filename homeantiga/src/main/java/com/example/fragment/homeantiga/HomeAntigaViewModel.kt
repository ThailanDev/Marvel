package com.example.fragment.homeantiga

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class HomeAntigaViewModel(
    private val statusDasRequisiCoes: StatusDasRequisiCoes
) : ViewModel() {
    init {
        Log.d("TAG", "init viewmodel home antiga")
        setup()
        coletarDados()
    }

    var job = Job()
    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "onCleared viewmodel home antiga")
    }

    fun setup() {
        viewModelScope.launch {
            delay(5000)
            Log.d("TAG", "chamada finalizada HomeAntigaViewModel")
            statusDasRequisiCoes.atualizarViewMode1(true)
        }
    }

    fun coletarDados() {
        viewModelScope.launch {
            statusDasRequisiCoes.getPegarTodos().collect {
                Log.d("dispacher", " getPegarTodos:${it} ")
            }
        }
    }
}