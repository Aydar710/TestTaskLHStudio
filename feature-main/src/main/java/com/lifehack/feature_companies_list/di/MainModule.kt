package com.lifehack.feature_companies_list.di

import com.lifehack.feature_companies_list.domain.ShowCompaniesUseCase
import com.lifehack.feature_companies_list.presentation.MainViewModel
import org.koin.dsl.module

val mainModule = module {

    factory { ShowCompaniesUseCase(get()) }
    factory { MainViewModel(get()) }
}