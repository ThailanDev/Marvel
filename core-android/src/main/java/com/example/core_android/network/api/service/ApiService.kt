package com.example.core_android.network.api.service

import com.example.core_android.network.api.model.characters.CharacterDataWrapper
import com.example.core_android.network.api.model.comic.ComicDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    suspend fun getCharacter(
        @Query("nameStartsWith") nameStartsWith: String? = null
    ): Response<CharacterDataWrapper>
    @GET("characters/{charactersId}/comics")
    suspend fun getComics(
        @Path(value = "characterId", encoded = true) characterId: Int
    ): Response<ComicDataWrapper>

}