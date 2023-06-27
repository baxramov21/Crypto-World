package com.sheikh.crytoworld.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.sheikh.crytoworld.R
import kotlinx.android.synthetic.main.activity_coin_detail.*

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        viewModel = ViewModelProviders.of(this)[CoinsViewModel::class.java]
        val intentFromCoinListActivity = intent
        val coinName = intentFromCoinListActivity.getStringExtra(KEYWORD_FOR_INTENT)
        if (coinName == null) {
            finish()
            return
        }

        viewModel.getCoinDetailData(coinName).observe(this, Observer {
            with(it) {
                Glide.with(this@CoinDetailActivity)
                    .load(getFullImageURL())
                    .error(R.drawable.not_found)
                    .into(imageViewCoinLogo)

                textViewCryptoName.text = fromSymbol
                textViewCurrencyName.text = toSymbol
                coinPrice.text = price.toString()
                coinHighestPrice.text = highDay.toString()
                coinLowestPrice.text = lowDay.toString()
                tvLastMarket.text = lastMarket
                tvLastUpdate.text = getLastUpdatedTime()
            }
        })

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