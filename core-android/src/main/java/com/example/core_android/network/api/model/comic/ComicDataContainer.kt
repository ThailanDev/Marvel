package com.example.core_android.network.api.model.comic

import com.google.gson.annotations.SerializedName

data class ComicDataContainer(
    @SerializedName("results")
    val comic: Comic
)
