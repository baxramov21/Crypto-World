package com.sheikh.crytoworld.presentation.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.databinding.ActivityCoinDetailBinding

class CoinDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCoinDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intentFromCoinListActivity = intent
        val coinName = intentFromCoinListActivity.getStringExtra(KEYWORD_FOR_INTENT)
        launchCoinDetailFragment(coinName)
    }

    private fun launchCoinDetailFragment(coinName: String?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(coinName))
            .commit()
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