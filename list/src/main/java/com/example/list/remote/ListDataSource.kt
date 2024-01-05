package com.example.list.remote

import android.util.Log
import com.example.core_android.network.api.service.ApiService
import com.example.list.repository.ListDataSourcerImp

class ListDataSource(val apiService: ApiService) : ListDataSourcerImp {
    override suspend fun getList() {
        val result = apiService.getCharacter()
        val reponse = result.body()
        Log.d("TAG", "getList: ${reponse}")
    }
}