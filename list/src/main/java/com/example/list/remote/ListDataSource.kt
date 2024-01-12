package com.example.list.remote

import arrow.core.Either
import com.example.core_android.gson.extension.fromJson
import com.example.core_android.gson.extension.resolveApi
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.core_android.network.api.service.ApiService
import com.example.list.repository.ListDataSourcerImp
import com.google.gson.Gson

internal class ListDataSource(private val apiService: ApiService) : ListDataSourcerImp {
    override suspend fun getList(): Either<Exception, CharacterDataWrapper?> {
        return try {
            val response = apiService.getCharacter<Any>(END_POINT_CHARACTER)
            val result = Gson().fromJson<CharacterDataWrapper>(response)
            Either.Right(result)
        } catch (e: Exception) {
            Either.Left(Exception())
        }
    }

    companion object {
        const val END_POINT_CHARACTER = "characters"
    }
}
