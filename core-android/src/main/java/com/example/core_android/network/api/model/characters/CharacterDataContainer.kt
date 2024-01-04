package com.example.core_android.network.api.model.characters

import com.google.gson.annotations.SerializedName

data class CharacterDataContainer(
    @SerializedName("results")
    val character: List<Character>? = listOf()
)
