package com.example.core_android.network.api.model.characters

import androidx.annotation.Keep

@Keep
data class Character(
    val id:Int?,
    val name :String?,
    val description  :String?,
    val thumbnail  : Image?,
)
