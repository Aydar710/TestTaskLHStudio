package com.lifehack.data.di

import com.lifehack.data.ApiService
import com.lifehack.data.repository.CompaniesRepository
import org.koin.dsl.module

val dataModule = module {
    single { ApiService.create() }
    single { CompaniesRepository(get()) }

}