package com.sheikh.crytoworld.presentation.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private val coinsListAdapter = CoinsListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)
        initRecyclerView()
        showCoinsList()
        if (isNetworkAvailable())
            mainViewModel.startLoading()

    }

    private fun showCoinsList() {
        mainViewModel.topCoins.observe(this) {
            coinsListAdapter.coinsList = it
            recyclerViewCoinList.layoutManager?.scrollToPosition(1)
        }
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = recyclerViewCoinList
        with(recyclerView) {
            recycledViewPool.setMaxRecycledViews(
                CoinsListAdapter.ITEM_VIEW_TYPE,
                CoinsListAdapter.RECYCLER_VIEW_POOL
            )

            adapter = coinsListAdapter
            layoutManager =
                LinearLayoutManager(
                    this@CoinListActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            coinsListAdapter.coinClickListener = object : CoinsListAdapter.CoinClickListener {
                override fun onCoinClick(item: CoinInfoEntity) {
                    val intent =
                        CoinDetailActivity.newIntent(
                            this@CoinListActivity,
                            item.fromSymbol
                        )
                    startActivity(intent)
                }
            }
        }
    }
}

fun Context.isNetworkAvailable(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
    return if (capabilities != null) {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    } else false
}