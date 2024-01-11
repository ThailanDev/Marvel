package com.example.list.repository

import arrow.core.Either
import com.example.core_android.network.api.model.characters.CharacterDataWrapper

internal class ListRepository(val dataSourcerImpl:ListDataSourcerImp) : ListRepositoryImpl {
    override suspend fun getList() : Either<Exception, CharacterDataWrapper?> {
       return dataSourcerImpl.getList()
    }
}

