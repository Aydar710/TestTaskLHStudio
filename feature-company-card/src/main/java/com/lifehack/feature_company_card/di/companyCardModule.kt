package com.lifehack.feature_company_card.di

import com.lifehack.feature_company_card.domain.ShowCompanyInfoUseCase
import com.lifehack.feature_company_card.presentation.CompanyCardViewModel
import org.koin.dsl.module

val companyCardModule = module {

    factory { ShowCompanyInfoUseCase(get()) }
    factory { CompanyCardViewModel(get()) }
}