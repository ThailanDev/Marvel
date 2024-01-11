package com.example.list.model.characters

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class  CharacterDataWrapper  @JvmOverloads constructor(
    @SerializedName("data")
    val characterDataContainer: CharacterDataContainer? = null
)