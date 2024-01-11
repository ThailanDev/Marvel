package com.example.list.model.comic

import com.example.list.model.characters.Image

data class Comic(
    val id:Int?,
    val name :String?,
    val description  :String?,
    val thumbnail  : Image?,
)
