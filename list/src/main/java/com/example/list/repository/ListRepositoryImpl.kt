package com.example.list.repository

import arrow.core.Either
import com.example.list.model.characters.CharacterDataWrapper

internal interface ListRepositoryImpl {
    suspend fun getList() : Either<Exception, CharacterDataWrapper?>
}
