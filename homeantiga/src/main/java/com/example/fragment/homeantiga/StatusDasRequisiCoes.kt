package com.example.fragment.homeantiga

import kotlinx.coroutines.flow.StateFlow

interface  StatusDasRequisiCoes{
    fun atualizarViewMode1(
        viewModel: Boolean = false,
    )

    fun atualizarViewMode2(
        viewModel: Boolean = false,
    )
    fun atualizarViewMode3(
        viewModel: Boolean = false,
    )
    fun atualizarViewMode4(
        viewModel: Boolean = false,
    )

    fun getPegarTodos(): StateFlow<Boolean>

}