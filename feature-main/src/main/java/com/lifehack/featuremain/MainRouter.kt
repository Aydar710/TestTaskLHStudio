package com.lifehack.featuremain

import androidx.appcompat.app.AppCompatActivity
import com.lifehack.data.model.Company

interface MainRouter {

    fun moveToCardActivity(activity: AppCompatActivity, company: Company)
}