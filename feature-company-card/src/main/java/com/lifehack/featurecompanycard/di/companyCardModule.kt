package com.lifehack.featurecompanycard.di

import com.lifehack.featurecompanycard.domain.ShowCompanyInfoUseCase
import com.lifehack.featurecompanycard.presentation.CompanyCardViewModel
import org.koin.dsl.module

val companyCardModule = module {

    factory { ShowCompanyInfoUseCase(get()) }
    factory { CompanyCardViewModel(get()) }
}