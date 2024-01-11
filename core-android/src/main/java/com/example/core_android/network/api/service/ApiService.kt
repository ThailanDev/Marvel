package com.example.core_android.network.api.service

import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{endpoint}")
    abstract suspend fun getCharacter (
        @Path("endpoint") endpoint: String,
        @Query("nameStartsWith") nameStartsWith: String? = null
    ): Response<CharacterDataWrapper>

}