package com.example.homenova

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val HomeNovaModule = module {
    viewModel { HomeNovaViewModel() }
}