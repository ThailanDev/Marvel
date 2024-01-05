package com.example.list

import com.example.list.remote.ListDataSource
import com.example.list.repository.ListDataSourcerImp
import com.example.list.repository.ListRepository
import com.example.list.repository.ListRepositoryImpl
import com.example.list.usecase.ListUseCase
import org.koin.dsl.module

val ListScreenModule = module {
    single <ListDataSourcerImp> { ListDataSource(get()) }
    single <ListRepositoryImpl> { ListRepository(get()) }
    single { ListUseCase(get()) }
}