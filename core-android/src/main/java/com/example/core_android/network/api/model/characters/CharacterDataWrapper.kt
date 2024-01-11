package com.example.core_android.network.api.model.characters

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class  CharacterDataWrapper(
    @SerializedName("data")
    val characterDataContainer: CharacterDataContainer? = null
) {
    constructor():this(null)
}