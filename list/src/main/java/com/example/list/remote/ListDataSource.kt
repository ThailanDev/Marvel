package com.example.list.remote

import android.util.Log
import arrow.core.Either
import com.example.list.model.characters.CharacterDataWrapper
import com.example.core_android.network.api.service.ApiService
import com.example.list.repository.ListDataSourcerImp
import retrofit2.Response

internal class ListDataSource(private val apiService: ApiService) : ListDataSourcerImp {
    override suspend fun getList() : Either<Exception, CharacterDataWrapper?> {
        return try {
            val result = apiService.getCharacter<CharacterDataWrapper>(END_POINT_CHARACTER)
            val data = result.body()
            Either.Right(data)
        } catch (e: Exception) {
            Log.d("getList", "getList: ${e} ")
           Either.Left(Exception())
        }
    }

    companion object{
        const val END_POINT_CHARACTER = "characters"
    }
}