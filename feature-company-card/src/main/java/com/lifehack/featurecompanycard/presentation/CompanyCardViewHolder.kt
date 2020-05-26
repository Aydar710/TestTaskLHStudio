package com.lifehack.featurecompanycard.presentation

import android.annotation.SuppressLint
import com.lifehack.data.model.CompanyFullInfo
import com.lifehack.featurecompanycard.R
import kotlinx.android.synthetic.main.activity_company_card.*

class CompanyCardViewHolder(private val activity: CompanyCardActivity) {

    @SuppressLint("SetTextI18n")
    fun bind(company: CompanyFullInfo) {
        with(activity) {
            iv_company.setImageResource(R.drawable.img_company)
            tv_company_name_value.text = company.name
            tv_company_description_value.text = company.description
            tv_company_location_value.text = "${company.lat};${company.lon}"
            tv_company_phone_value.text = company.phone
        }
    }
}