package com.example.core_android.network.api.model.characters

import com.google.gson.annotations.SerializedName

data class CharacterDataWrapper(
    @SerializedName("data")
    val characterDataContainer: CharacterDataContainer? = null
)