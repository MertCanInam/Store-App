package com.mertinam.storeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat

import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mertinam.countryapp.R
import com.mertinam.countryapp.R.layout
import com.mertinam.countryapp.databinding.ActivityMainBinding
import com.mertinam.storeapp.adapter.ProductAdapter
import com.mertinam.storeapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding
    private var productAdapter = ProductAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.productRV.adapter = productAdapter
        binding.productRV.layoutManager = LinearLayoutManager(this)
        viewModel.getDataFromAPI()
        setObservers()






    }

    private fun setObservers()
    {
         viewModel.productData.observe(this, Observer { list ->
             productAdapter.updateList(list)


         })
        viewModel.productLoad.observe(this, Observer { loading ->
            if(loading)
                binding.loadingPB.visibility= View.VISIBLE
            else
                binding.loadingPB.visibility = View.GONE

        })
        viewModel.productError.observe(this, Observer { error ->
            if(error)
                binding.errorTV.visibility = View.VISIBLE
            else
                binding.errorTV.visibility = View.GONE

        })

    }



}

