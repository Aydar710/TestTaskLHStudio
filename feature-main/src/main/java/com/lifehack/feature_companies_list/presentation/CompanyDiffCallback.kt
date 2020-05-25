package com.lifehack.feature_companies_list.presentation

import androidx.recyclerview.widget.DiffUtil
import com.lifehack.data.model.Company

class CompanyDiffCallback : DiffUtil.ItemCallback<Company>() {

    override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean =
        oldItem == newItem


}