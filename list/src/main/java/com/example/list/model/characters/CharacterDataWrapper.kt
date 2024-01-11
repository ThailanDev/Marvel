package com.example.list.model.characters

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class  CharacterDataWrapper(
    @SerializedName("data")
    val characterDataContainer: CharacterDataContainer? = null
)