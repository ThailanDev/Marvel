package com.example.list.model.characters

import com.google.gson.annotations.SerializedName

data class CharacterDataContainer(
    @SerializedName("results")
    val character: List<Character>? = listOf()
)
