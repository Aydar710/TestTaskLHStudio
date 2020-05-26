package com.lifehack.featurecompanycard.presentation

import android.util.MalformedJsonException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifehack.common.Commands
import com.lifehack.common.SingleLiveEvent
import com.lifehack.data.model.CompanyFullInfo
import com.lifehack.featurecompanycard.domain.ShowCompanyInfoUseCase
import kotlinx.coroutines.launch

class CompanyCardViewModel(private val showCompanyInfoUseCase: ShowCompanyInfoUseCase) :
    ViewModel() {

    private val _companyLiveData =
        MutableLiveData<CompanyFullInfo>()

    val companyLiveData: LiveData<CompanyFullInfo>
        get() = _companyLiveData

    private val _command: SingleLiveEvent<Commands> = SingleLiveEvent()
    val command: LiveData<Commands>
        get() = _command

    fun showCompanyInfo(id: Int) {
        viewModelScope.launch {
            try {
                _command.value = Commands.ShowProgress
                val company = showCompanyInfoUseCase.invoke(id)
                _companyLiveData.postValue(company)
            } catch (e: Exception) {
                e.printStackTrace()
                if (e is MalformedJsonException) {
                    _command.value = Commands.ShowJsonError
                } else {
                    _command.value = Commands.ShowError
                }
            }
            _command.value = Commands.HideProgress
        }
    }
}