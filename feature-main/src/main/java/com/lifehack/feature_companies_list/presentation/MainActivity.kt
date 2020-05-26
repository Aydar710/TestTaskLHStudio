package com.lifehack.feature_companies_list.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lifehack.common.Commands
import com.lifehack.feature_companies_list.MainRouter
import com.lifehack.feature_companies_list.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: CompaniesAdapter
    private val router: MainRouter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        observeCommands()
        showCompanies()
    }

    private fun initRecycler() {
        adapter = CompaniesAdapter {
            router.moveToCardActivity(this, it)
        }
        rv_companies.adapter = adapter
    }

    private fun showCompanies() {
        viewModel.showCompanies()
        viewModel.companiesLiveData.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun observeCommands() {
        viewModel.command.observe(this, Observer {
            when (it) {
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
        rv_companies.visibility = View.GONE
        pb_main.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        rv_companies.visibility = View.VISIBLE
        pb_main.visibility = View.GONE
    }
}
