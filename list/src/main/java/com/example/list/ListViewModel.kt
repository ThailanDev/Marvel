package com.example.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.usecase.ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val useCase: ListUseCase
) : ViewModel() {
    fun getList(){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getList()
        }
    }
}