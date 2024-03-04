package com.example.fragment.homeantiga

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StatusDasRequisiCoesImpl : StatusDasRequisiCoes {

    val _estadoAtual = MutableStateFlow(false)

    var viewModel1: Boolean = false
    var viewModel2: Boolean = false
    var viewModel3: Boolean = false
    var viewModel4: Boolean = false

    override fun atualizarViewMode1(viewModel: Boolean) {
        viewModel1 = viewModel
        todosVerdadeiros()
    }

    override fun atualizarViewMode2(viewModel: Boolean) {
        viewModel2 = viewModel
        todosVerdadeiros()
    }

    override fun atualizarViewMode3(viewModel: Boolean) {
        viewModel3 = viewModel
        todosVerdadeiros()
    }

    override fun atualizarViewMode4(viewModel: Boolean) {
        viewModel4= viewModel
        todosVerdadeiros()
    }

    fun todosVerdadeiros() {
        if(viewModel1 && viewModel2 && viewModel3 && viewModel4){
            _estadoAtual.update { true }
        }
    }

    override fun getPegarTodos() =  _estadoAtual.asStateFlow()

}