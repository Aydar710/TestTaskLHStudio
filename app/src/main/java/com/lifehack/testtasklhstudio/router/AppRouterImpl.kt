package com.lifehack.testtasklhstudio.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.lifehack.data.model.Company
import com.lifehack.featurecompanycard.presentation.CompanyCardActivity

class AppRouterImpl : AppRouter {

    override fun moveToCardActivity(activity: AppCompatActivity, company: Company) {
        val intent = Intent(activity, CompanyCardActivity::class.java)
        intent.putExtra(com.lifehack.common.EXTRA_COMPANY, company)
        activity.startActivity(intent)
    }
}