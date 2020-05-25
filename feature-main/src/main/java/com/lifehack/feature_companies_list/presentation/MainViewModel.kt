package com.lifehack.feature_companies_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifehack.data.model.Company
import com.lifehack.feature_companies_list.domain.ShowCompaniesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val showCompaniesUseCase: ShowCompaniesUseCase) : ViewModel() {

    private val _companiesLiveData =
        MutableLiveData<List<Company>>()

    val questionsLiveData: LiveData<List<Company>>
        get() = _companiesLiveData

    fun showCompanies() {
        viewModelScope.launch {
            val companies = showCompaniesUseCase.invoke()
            _companiesLiveData.postValue(companies)
        }
    }
}