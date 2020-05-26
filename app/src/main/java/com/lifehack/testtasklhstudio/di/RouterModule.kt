package com.lifehack.testtasklhstudio.di

import com.lifehack.featuremain.MainRouter
import com.lifehack.testtasklhstudio.router.AppRouterImpl
import org.koin.dsl.module

val routerModule = module {
    single<MainRouter> { AppRouterImpl() }
}
