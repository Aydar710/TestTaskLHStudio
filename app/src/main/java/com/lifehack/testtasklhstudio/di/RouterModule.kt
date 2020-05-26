package com.lifehack.testtasklhstudio.di

import com.lifehack.feature_companies_list.MainRouter
import com.lifehack.testtasklhstudio.router.AppRouterImpl
import org.koin.dsl.module

val routerModule = module {
    single<MainRouter> { AppRouterImpl() }
}
