package com.example.list.usecase

import com.example.list.repository.ListRepositoryImpl

class ListUseCase(
    val repository: ListRepositoryImpl
) {
    suspend fun getList() {
        repository.getList()
    }
}
