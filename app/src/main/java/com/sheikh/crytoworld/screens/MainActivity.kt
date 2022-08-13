package com.sheikh.crytoworld.screens

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.viewmodel.CoinsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var coinsViewModel: CoinsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinsViewModel = ViewModelProviders.of(this)[CoinsViewModel::class.java]
        coinsViewModel.coinPriceInfo.observe(this, Observer {

        })

        coinsViewModel.getCoinDetailData("ETH").observe(this) {
            Log.d("about_coin", it.toString())
        }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCoinList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}