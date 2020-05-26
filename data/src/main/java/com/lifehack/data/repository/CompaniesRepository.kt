package com.lifehack.data.repository

import com.lifehack.data.ApiService
import com.lifehack.data.model.Company
import com.lifehack.data.model.CompanyFullInfo

class CompaniesRepository(private val service: ApiService) {

    suspend fun getCompanies(): List<Company> {
        return service.getCompanies()
    }

    suspend fun getCompanyInfo(id: Int): CompanyFullInfo {
        return service.getCompanyInfo(id)[0]
    }
}