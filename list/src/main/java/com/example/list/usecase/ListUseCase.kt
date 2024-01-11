package com.example.list.usecase

import arrow.core.Either
import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.list.repository.ListRepositoryImpl

internal class ListUseCase(
    private val repository: ListRepositoryImpl
) {
    internal suspend operator fun invoke() : Either<Exception, CharacterDataWrapper?> {
        return repository.getList()
    }
}
