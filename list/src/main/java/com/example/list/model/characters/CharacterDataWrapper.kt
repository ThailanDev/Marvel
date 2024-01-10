package com.example.list.model.characters

import com.google.gson.annotations.SerializedName

data class CharacterDataWrapper(
    @SerializedName("data")
    val characterDataContainer: CharacterDataContainer? = null
)