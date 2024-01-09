package com.example.list

import android.util.Log
import androidx.lifecycle.LiveData
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

    private val _currentScrambledWord = MutableLiveData<ListState>()
    val currentScrambledWord: LiveData<ListState>
        get() = _currentScrambledWord

    init {
        getList()
    }

    private fun getList() {
        _currentScrambledWord.value =  ListState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            useCase().fold(::isError, ::isSuccess)
        }
    }

    private fun isError(e: Exception) {
        _currentScrambledWord.value =  ListState(isError = true, isLoading = false)
    }

    private fun isSuccess(data: CharacterDataWrapper?) {
        _currentScrambledWord.value = ListState(data = data)
    }

    internal data class ListState(
        var data: CharacterDataWrapper? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )

}