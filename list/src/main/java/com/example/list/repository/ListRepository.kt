package com.example.list.repository

class ListRepository(val dataSourcerImpl:ListDataSourcerImp) : ListRepositoryImpl {
    override suspend fun getList() {
       dataSourcerImpl.getList()
    }
}

