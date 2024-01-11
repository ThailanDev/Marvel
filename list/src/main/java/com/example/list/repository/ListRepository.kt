package com.example.list.repository

import arrow.core.Either
import com.example.list.model.characters.CharacterDataWrapper

internal class ListRepository(val dataSourcerImpl:ListDataSourcerImp) : ListRepositoryImpl {
    override suspend fun getList() : Either<Exception, CharacterDataWrapper?> {
       return dataSourcerImpl.getList()
    }
}

