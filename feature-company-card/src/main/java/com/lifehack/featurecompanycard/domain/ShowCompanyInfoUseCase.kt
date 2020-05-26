package com.lifehack.featurecompanycard.domain

import com.lifehack.data.model.CompanyFullInfo
import com.lifehack.data.repository.CompaniesRepository

class ShowCompanyInfoUseCase(private val companiesRepository: CompaniesRepository) {

    suspend fun invoke(id: Int): CompanyFullInfo {
        return companiesRepository.getCompanyInfo(id)
    }
}