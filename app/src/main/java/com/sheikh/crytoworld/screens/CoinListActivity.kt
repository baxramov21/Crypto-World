package com.sheikh.crytoworld.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.adapters.CoinsListAdapter
import com.sheikh.crytoworld.pojos.coin_full_info.CoinPriceInfo
import com.sheikh.crytoworld.viewmodel.CoinsViewModel
import kotlinx.android.synthetic.main.activity_coin_list.*

class CoinListActivity : AppCompatActivity() {

    private lateinit var coinsViewModel: CoinsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)
        val adapter = CoinsListAdapter(this)
        adapter.coinClickListener = object : CoinsListAdapter.CoinClickListener {
            override fun onCoinClick(coin: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(this@CoinListActivity, coin.fromSymbol)
                startActivity(intent)
            }
        }
        val recyclerView: RecyclerView = recyclerViewCoinList
        recyclerView.adapter = adapter

        coinsViewModel = ViewModelProviders.of(this)[CoinsViewModel::class.java]
        coinsViewModel.coinPriceInfo.observe(this, Observer {
            adapter.coinsList = it
        })
    }
}