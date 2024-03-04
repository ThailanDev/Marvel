package com.example.fragment.topo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment.homeantiga.StatusDasRequisiCoes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


class TopoDaHomeViewModel(
    private val statusDasRequisiCoes: StatusDasRequisiCoes
): ViewModel() {
    init {
        setup()
    }
    fun setup() {
        Log.d("dispacher", " TopoDaHomeViewModel init")
        viewModelScope.launch {
            delay(9000)
            statusDasRequisiCoes.atualizarViewMode2(true)
            Log.d("TAG", "chamada finalizada TopoDaHomeViewModel")
        }
    }

}
