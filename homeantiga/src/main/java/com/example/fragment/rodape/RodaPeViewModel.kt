package com.example.fragment.rodape

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment.homeantiga.StatusDasRequisiCoes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class RodaPeViewModel(
    private val statusDasRequisiCoes: StatusDasRequisiCoes
): ViewModel() {
    init {
        setup()
    }
    fun setup() {
        Log.d("dispacher", " RodaPeViewModel init")
        viewModelScope.launch {
            delay(8000)
            statusDasRequisiCoes.atualizarViewMode3(true)
            Log.d("TAG", "chamada finalizada RodaPeViewModel")
        }
    }

}
