package com.example.core_android.network.api.model.comic

import com.google.gson.annotations.SerializedName

data class ComicDataWrapper(
    @SerializedName("data")
    val comicDataContainer: ComicDataContainer
)
