package com.example.di

import com.example.SwipeRefreshCustom
import com.example.SwipeRefreshCustomImpl
import com.example.fragment.corpo.CorpoViewModel
import com.example.fragment.homeantiga.HomeAntigaViewModel
import com.example.fragment.homeantiga.StatusDasRequisiCoes
import com.example.fragment.homeantiga.StatusDasRequisiCoesImpl
import com.example.fragment.rodape.RodaPeViewModel
import com.example.fragment.topo.TopoDaHomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val HomeAntigaModule = module {

    single (named("single")) { Dispatchers.IO }
    single<StatusDasRequisiCoes> { StatusDasRequisiCoesImpl() }

    viewModel { HomeAntigaViewModel(get()) }
    viewModel { CorpoViewModel(get()) }
    viewModel { RodaPeViewModel(get()) }
    viewModel { TopoDaHomeViewModel(get()) }
}