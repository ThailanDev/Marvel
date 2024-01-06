package com.example.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.list.usecase.ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val useCase: ListUseCase
) : ViewModel() {
    init {
        getList()
    }

    private fun getList(){
        viewModelScope.launch(Dispatchers.IO) {
            useCase().fold(::isError, ::isSuccess)
        }
    }

    private fun isError(e:Exception){

    }

    private fun isSuccess(data: CharacterDataWrapper?){

    }

}