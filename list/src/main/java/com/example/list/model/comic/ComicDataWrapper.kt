package com.example.list.model.comic

import com.google.gson.annotations.SerializedName

data class ComicDataWrapper(
    @SerializedName("data")
    val comicDataContainer: ComicDataContainer
)
