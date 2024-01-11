package com.example.list.model.comic

import com.google.gson.annotations.SerializedName

data class ComicDataContainer(
    @SerializedName("results")
    val comic: Comic
)
