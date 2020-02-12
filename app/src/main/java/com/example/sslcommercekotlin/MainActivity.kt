package com.example.sslcommercekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization
import com.sslwireless.sslcommerzlibrary.model.response.TransactionInfoModel
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.TransactionResponseListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TransactionResponseListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sslCommerzInitialization = SSLCommerzInitialization(
            "self5e4a7bc6ae",// store id and store password  will  provided by sslCommerce Live create account or Sandbox account
            "self5e7bc6ae@ssl",
            5.0,
            "BDT",
            "suriya10",
            "FOOD",
            "SANDBOX" // If live  account then provide LIVE or Sandbox then provide SANDBOX
        )

        paymentButton.setOnClickListener {
            IntegrateSSLCommerz.getInstance(this)
                .addSSLCommerzInitialization(sslCommerzInitialization).buildApiCall(this)
        }


    }

    override fun transactionFail(p0: String?) {

        Log.d("MyLog", "transactionFail called")
    }

    override fun merchantValidationError(p0: String?) {
        Log.d("MyLog", "merchantValidationError called")
    }

    override fun transactionSuccess(p0: TransactionInfoModel?) {

        Log.d("MyLog", "transactionSuccess called")
    }


}
