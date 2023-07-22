package com.sheikh.crytoworld.presentation.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheikh.crytoworld.databinding.ActivityCoinListBinding
import com.sheikh.crytoworld.presentation.adapters.CoinsListAdapter
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.presentation.view_model.MainViewModel
import com.sheikh.crytoworld.presentation.view_model.MyViewModelFactory

class CoinsListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCoinListBinding.inflate(layoutInflater)
    }

    private val myViewModelFactory by lazy {
        MyViewModelFactory(application)
    }

    private val mainViewModel by lazy {
        ViewModelProvider(this, myViewModelFactory)[MainViewModel::class.java]
    }

    private val coinsListAdapter = CoinsListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
        showCoinsList()
        if (isNetworkAvailable())
            mainViewModel.startLoading()
        else
            Toast.makeText(
                this,
                "Please check your internet connection and try again",
                Toast.LENGTH_SHORT
            ).show()
    }

    private fun showCoinsList() {
        mainViewModel.topCoins.observe(this) {
            coinsListAdapter.submitList(it)
            binding.recyclerViewCoinList.layoutManager?.scrollToPosition(1)
        }
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerViewCoinList
//        recyclerView.itemAnimator = null
        with(recyclerView) {
            recycledViewPool.setMaxRecycledViews(
                CoinsListAdapter.ITEM_VIEW_TYPE,
                CoinsListAdapter.RECYCLER_VIEW_POOL
            )

            adapter = coinsListAdapter
            layoutManager =
                LinearLayoutManager(
                    this@CoinsListActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

            coinsListAdapter.coinClickListener = object : CoinsListAdapter.CoinClickListener {
                override fun onCoinClick(item: CoinInfoEntity) {
                    val intent =
                        CoinDetailActivity.newIntent(
                            this@CoinsListActivity,
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