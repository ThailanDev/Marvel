package com.example.core_android.network.api.model.comic

import com.example.core_android.network.api.model.characters.Image

data class Comic(
    val id:Int?,
    val name :String?,
    val description  :String?,
    val thumbnail  : Image?,
)
