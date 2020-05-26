package com.lifehack.featurecompanycard.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lifehack.common.Commands
import com.lifehack.common.EXTRA_COMPANY
import com.lifehack.data.model.Company
import com.lifehack.featurecompanycard.R
import kotlinx.android.synthetic.main.activity_company_card.*
import org.koin.android.viewmodel.ext.android.viewModel

class CompanyCardActivity : AppCompatActivity() {

    private val viewModel: CompanyCardViewModel by viewModel()
    private lateinit var viewHolder: CompanyCardViewHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_card)

        viewHolder = CompanyCardViewHolder(this)
        observeCommands()
        val company = intent.getSerializableExtra(EXTRA_COMPANY) as Company
        showCompanyInfo(company.id)
    }

    private fun showCompanyInfo(id: Int?) {
        id?.let { viewModel.showCompanyInfo(it) }

        viewModel.companyLiveData.observe(this, Observer {
            viewHolder.bind(it)
        })
    }

    private fun observeCommands() {
        viewModel.command.observe(this, Observer {
            when (it) {
                is Commands.ShowJsonError -> {
                    Toast.makeText(this, "Json Error", Toast.LENGTH_SHORT).show()
                }
                is Commands.ShowError -> {
                    Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
                }
                is Commands.ShowProgress -> {
                    showProgress()
                }
                is Commands.HideProgress -> {
                    hideProgress()
                }
            }
        })
    }

    private fun showProgress() {
        cl_company_card.visibility = View.INVISIBLE
        pb_card.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        cl_company_card.visibility = View.VISIBLE
        pb_card.visibility = View.GONE
    }
}
