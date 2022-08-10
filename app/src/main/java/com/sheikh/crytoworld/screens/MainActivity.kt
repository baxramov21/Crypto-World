package com.sheikh.crytoworld.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.adapters.CoinsListAdapter
import com.sheikh.crytoworld.pojos.top_coins_list.coin_info.CoinInfo
import com.sheikh.crytoworld.retorfit.ApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCoinList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val coinsListAdapter = CoinsListAdapter()
        recyclerView.adapter = coinsListAdapter
        val apiService = ApiFactory.apiService
        val coins = apiService.getTopCoins()
        val disposable = coins.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val list = arrayListOf(it.topCoinsList?.get(0)?.coinInfo)
                val notNullList: ArrayList<CoinInfo> = ArrayList()
                list[0]?.let {
                    notNullList.add(it)
                }
                Log.d("process_result", " message1: ${notNullList.size}")
                Log.d("process_result", " message2: ${it.toString()}")
                coinsListAdapter.coinsList = notNullList
            }, {
                Log.e("process_result", "Error message: ${it.message}")
                throw Exception()
            })

        compositeDisposable?.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable?.let {
            it.dispose()
        }
        super.onDestroy()
    }
}