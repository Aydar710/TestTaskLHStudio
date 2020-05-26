package com.lifehack.featuremain.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lifehack.data.model.Company
import com.lifehack.featuremain.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_company.view.*

class CompaniesAdapter(private val onCompanyClicked : (Company) -> Unit) :
    ListAdapter<Company, CompaniesAdapter.CompanyViewHolder>(CompanyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return CompanyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CompanyViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(company: Company) {
            with(containerView) {
                tv_company_name.text = company.name
                iv_company.setImageResource(R.drawable.img_company)

                setOnClickListener {
                    onCompanyClicked.invoke(company)
                }
            }
        }
    }
}