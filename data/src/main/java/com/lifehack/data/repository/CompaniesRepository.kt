package com.lifehack.data.repository

import com.lifehack.data.ApiService
import com.lifehack.data.model.Company

class CompaniesRepository(private val service: ApiService) {

    suspend fun getCompanies(): List<Company> {
        return service.getCompanies()
    }
}