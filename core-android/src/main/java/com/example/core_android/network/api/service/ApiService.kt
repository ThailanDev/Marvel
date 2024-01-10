package com.example.core_android.network.api.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{endpoint}")
    suspend fun <T> getCharacter(
        @Path("endpoint") endpoint: String,
        @Query("nameStartsWith") nameStartsWith: String? = null
    ): Response<T>
//    @GET("characters/{charactersId}/comics")
//    suspend fun getComics(
//        @Path(value = "characterId", encoded = true) characterId: Int
//    ): Response<ComicDataWrapper>

}