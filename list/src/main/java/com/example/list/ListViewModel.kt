package com.example.list

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

    var state = MutableLiveData<ListState>()
        private set

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase().fold(::isError, ::isSuccess)
        }
    }

    private fun isError(e: Exception) {
        state.value?.copy(isError = true)
    }

    private fun isSuccess(data: CharacterDataWrapper?) {
        state.postValue(ListState(data = data))
    }

    internal data class ListState(
        val data: CharacterDataWrapper?,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )

}