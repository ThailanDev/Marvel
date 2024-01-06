package com.example.list.remote

import arrow.core.Either
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.core_android.network.api.service.ApiService
import com.example.list.repository.ListDataSourcerImp

class ListDataSource(val apiService: ApiService) : ListDataSourcerImp {
    override suspend fun getList() : Either<Exception, CharacterDataWrapper?> {
        return try {
            val result = apiService.getCharacter()
            val data = result.body()
            Either.Right(data)
        } catch (e: Exception) {
           Either.Left(Exception())
        }
    }
}