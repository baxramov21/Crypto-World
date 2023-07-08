package com.sheikh.crytoworld.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.presentation.adapters.CoinsListAdapter
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.presentation.view_model.MainViewModel
import com.sheikh.crytoworld.presentation.view_model.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_coin_list.*

class CoinListActivity : AppCompatActivity() {

    private val myViewModelFactory by lazy {
        MyViewModelFactory(application)
    }

    private val mainViewModel by lazy {
        ViewModelProvider(this, myViewModelFactory)[MainViewModel::class.java]
    }

    private val adapter = CoinsListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)
        initRecyclerView()
        showCoinsList()
    }


    private fun showCoinsList() {
        mainViewModel.topCoins.observe(this) {
            adapter.coinsList = it
        }
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = recyclerViewCoinList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.coinClickListener = object : CoinsListAdapter.CoinClickListener {
            override fun onCoinClick(item: CoinInfoEntity) {
                val intent =
                    CoinDetailActivity.newIntent(this@CoinListActivity, item.fromSymbol)
                startActivity(intent)
            }
        }
    }
}