package com.lifehack.feature_companies_list.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lifehack.feature_companies_list.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter : CompaniesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        showCompanies()
    }

    private fun initRecycler(){
        adapter = CompaniesAdapter()
        rv_companies.adapter = adapter
    }

    private fun showCompanies() {
        viewModel.showCompanies()
        viewModel.questionsLiveData.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
