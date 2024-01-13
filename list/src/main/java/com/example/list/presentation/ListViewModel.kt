package com.example.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.list.usecase.ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class ListViewModel(
    private val useCase: ListUseCase
) : ViewModel() {

    private val _state = MutableLiveData<ListState>()
    val state: LiveData<ListState>
        get() = _state

    init {
        _state.postValue(ListState(data = CharacterDataWrapper()))
        getList()
    }

    private fun getList() {
        _state.postValue(ListState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            useCase().fold(::isError, ::isSuccess)
        }
    }

    private fun isError(e: Exception) {
        _state.postValue(ListState(isError = true, isLoading = false))
    }

    private fun isSuccess(data: CharacterDataWrapper?) {
        viewModelScope.launch {
            delay(5000)
            _state.postValue(_state.value?.copy(data = data, isLoading = false))
        }
    }

    internal data class ListState(
        var data: CharacterDataWrapper? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )

}