package com.example.cleanarchitecturetryout.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cleanarchitecturetryout.R
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.main.MainRequest
import com.example.cleanarchitecturetryout.domain.main.MainResponse
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelFactory
import com.example.cleanarchitecturetryout.ui.ecommerce.view.EcommerceActivity
import com.example.cleanarchitecturetryout.ui.main.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        btnCallApi.setOnClickListener {
            val request = MainRequest()
            request.mobileNumber = "9994162605"
            mainViewModel.callSendOtp(request)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.observeResponse().observe(this, object : Observer<Resource<MainResponse>> {
            override fun onChanged(resource: Resource<MainResponse>?) {
                when(resource!!.status) {
                    Resource.Status.LOADING -> {
                        Log.e("MainActivity", "Loading....")
                    }

                    Resource.Status.SUCCESS -> {
                        Log.e("MainActivity", "Success....")
                    }

                    Resource.Status.ERROR -> {
                        Log.e("MainActivity", "Error....")

                        val intent = Intent(this@MainActivity, EcommerceActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        })
    }
}
