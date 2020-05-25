package com.lifehack.feature_companies_list.domain

import com.lifehack.data.model.Company
import com.lifehack.data.repository.CompaniesRepository

class ShowCompaniesUseCase(private val companiesRepository: CompaniesRepository) {

    suspend fun invoke(): List<Company> {
        return companiesRepository.getCompanies()
    }
}