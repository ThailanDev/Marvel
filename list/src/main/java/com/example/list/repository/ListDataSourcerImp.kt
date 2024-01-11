package com.example.list.repository

import arrow.core.Either
import com.example.list.model.characters.CharacterDataWrapper

internal interface ListDataSourcerImp {
    suspend fun getList(): Either<Exception, CharacterDataWrapper?>
}
