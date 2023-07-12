package com.sheikh.crytoworld.presentation.screens

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.presentation.view_model.MainViewModel
import com.sheikh.crytoworld.presentation.view_model.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_coin_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class CoinDetailActivity : AppCompatActivity() {


    private val myViewModelFactory by lazy {
        MyViewModelFactory(application)
    }
    private val mainViewModel by lazy {
        ViewModelProvider(this, myViewModelFactory)[MainViewModel::class.java]
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val coroutineScopeMain = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        val intentFromCoinListActivity = intent
        val coinName = intentFromCoinListActivity.getStringExtra(KEYWORD_FOR_INTENT)
        if (coinName == null) {
            finish()
            return
        }

        coroutineScope.launch {
            val coinInfo = mainViewModel.getCoin(coinName)
            with(coinInfo) {
                coroutineScopeMain.launch {
                    Glide.with(this@CoinDetailActivity)
                        .load(imageUrl)
                        .placeholder(R.drawable.cryptocurrencies)
                        .into(imageViewCoinLogo)
                }
                textViewCryptoName.text = fromSymbol
                textViewCurrencyName.text = toSymbol
                coinPrice.text = price.toString()
                coinHighestPrice.text = highDay.toString()
                coinLowestPrice.text = lowDay.toString()
                tvLastMarket.text = lastMarket
                tvLastUpdate.text =
                    String.format(
                        Locale.getDefault(),
                        getString(R.string.last_update),
                        lastUpdate
                    )

            }
        }
    }

    companion object {
        private const val KEYWORD_FOR_INTENT = "fSym"

        fun newIntent(context: Context, coinName: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(KEYWORD_FOR_INTENT, coinName)
            return intent
        }
    }
}