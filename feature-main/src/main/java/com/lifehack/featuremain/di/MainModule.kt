package com.lifehack.featuremain.di

import com.lifehack.featuremain.domain.ShowCompaniesUseCase
import com.lifehack.featuremain.presentation.MainViewModel
import org.koin.dsl.module

val mainModule = module {

    factory { ShowCompaniesUseCase(get()) }
    factory { MainViewModel(get()) }
}