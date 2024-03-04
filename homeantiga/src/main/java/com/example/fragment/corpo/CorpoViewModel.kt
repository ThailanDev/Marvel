package com.example.fragment.corpo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment.homeantiga.StatusDasRequisiCoes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class CorpoViewModel(
    private val statusDasRequisiCoes: StatusDasRequisiCoes
):ViewModel() {

init {
    setup()
}
    fun setup() {
        Log.d("dispacher", " CorpoViewModel init")
      viewModelScope.launch {
          delay(7000)
          statusDasRequisiCoes.atualizarViewMode4(true)
          Log.d("TAG", "chamada finalizada CorpoViewModel")
      }
    }

}
