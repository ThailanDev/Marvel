package com.example.list.remote

import android.util.Log
import arrow.core.Either
import com.example.core_android.network.api.service.ApiService
import com.example.list.model.characters.CharacterDataWrapper
import com.example.list.repository.ListDataSourcerImp

internal class ListDataSource(private val apiService: ApiService) : ListDataSourcerImp {
    override suspend fun getList(): Either<Exception, CharacterDataWrapper?> {
        return try {
            val result = apiService.getCharacter<CharacterDataWrapper>(END_POINT_CHARACTER)
            Log.d("response", "getList: ${result} ")
            Either.Right(CharacterDataWrapper())
        } catch (e: Exception) {
            Log.d("response", "getList: ${e} ")
            Either.Left(Exception())
        }
    }

    companion object {
        const val END_POINT_CHARACTER = "characters"
    }
}
