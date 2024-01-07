package com.example.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.list.usecase.ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class ListViewModel(
    private val useCase: ListUseCase
) : ViewModel() {

    val state : MutableLiveData<ListState> by lazy { MutableLiveData<ListState>()  }
        private set

    init {
        getList()
    }

    private fun getList() {
        state.postValue(state.value?.copy(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            useCase().fold(::isError, ::isSuccess)
        }
    }

    private fun isError(e: Exception) {
        state.postValue(state.value?.copy(isError = true, isLoading = false))
    }

    private fun isSuccess(data: CharacterDataWrapper?) {
        state.postValue(state.value?.copy(data = data, isLoading = false))
    }

    internal data class ListState(
        var data: CharacterDataWrapper?,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )

}