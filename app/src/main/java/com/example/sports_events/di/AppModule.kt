package com.example.sports_events.di

import com.example.domain.usecase.GetSportsUseCase
import com.example.sports_events.viewmodel.SportsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object AppModule {

    fun loadModules() {
        loadKoinModules(appModule)
    }

    private val appModule = module {
        viewModel { SportsViewModel(get()) }
    }

}