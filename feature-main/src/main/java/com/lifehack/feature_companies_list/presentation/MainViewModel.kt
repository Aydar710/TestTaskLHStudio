package com.lifehack.feature_companies_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifehack.common.Commands
import com.lifehack.common.SingleLiveEvent
import com.lifehack.data.model.Company
import com.lifehack.feature_companies_list.domain.ShowCompaniesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val showCompaniesUseCase: ShowCompaniesUseCase) : ViewModel() {

    private val _companiesLiveData =
        MutableLiveData<List<Company>>()

    val companiesLiveData: LiveData<List<Company>>
        get() = _companiesLiveData

    private val _command: SingleLiveEvent<Commands> = SingleLiveEvent()
    val command: LiveData<Commands>
        get() = _command

    fun showCompanies() {
        viewModelScope.launch {
            _command.postValue(Commands.ShowProgress)
            val companies = showCompaniesUseCase.invoke()
            _companiesLiveData.postValue(companies)
            _command.postValue(Commands.HideProgress)
        }
    }
}