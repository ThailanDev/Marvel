package com.example.list.repository

import arrow.core.Either
import com.example.core_android.network.api.model.characters.CharacterDataWrapper

interface ListRepositoryImpl {
    suspend fun getList() : Either<Exception, CharacterDataWrapper?>
}
