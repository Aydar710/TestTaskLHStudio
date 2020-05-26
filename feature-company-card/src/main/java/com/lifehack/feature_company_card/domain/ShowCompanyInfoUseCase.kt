package com.lifehack.feature_company_card.domain

import com.lifehack.data.model.CompanyFullInfo
import com.lifehack.data.repository.CompaniesRepository

class ShowCompanyInfoUseCase(private val companiesRepository: CompaniesRepository) {

    suspend fun invoke(id: Int): CompanyFullInfo {
        return companiesRepository.getCompanyInfo(id)
    }
}