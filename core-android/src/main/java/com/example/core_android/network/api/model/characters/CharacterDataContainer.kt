package com.example.core_android.network.api.model.characters

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class CharacterDataContainer(
    @SerializedName("results")
    val character: List<Character>? = listOf()
)
