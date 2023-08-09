package com.sheikh.crytoworld.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.databinding.FragmentCoinDetailBinding
import com.sheikh.crytoworld.presentation.view_model.MainViewModel
import com.sheikh.crytoworld.presentation.view_model.MyViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class CoinDetailFragment : Fragment() {

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw NullPointerException("FragmentCoinDetailBinding is null")

    private val myViewModelFactory by lazy {
        MyViewModelFactory(requireActivity().application)
    }
    private val mainViewModel by lazy {
        ViewModelProvider(this, myViewModelFactory)[MainViewModel::class.java]
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val coroutineScopeMain = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coinName = getArgs()
        setUIValues(coinName)
    }

    private fun setUIValues(coinName: String) {
        coroutineScope.launch {
            val coinInfo = mainViewModel.getCoin(coinName)
            with(coinInfo) {
                with(binding) {
                    coroutineScopeMain.launch {
                        Glide.with(requireActivity())
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
                    tvLastUpdate.text = lastUpdate
                }
            }
        }
    }

    private fun getArgs(): String {
        return requireArguments().getString(PARAM_FROM_SYMBOL, EMPTY_STRING)
    }

    override fun onDestroy() {
        if (_binding != null) {
            _binding = null
        }
        super.onDestroy()
    }

    companion object {
        private const val PARAM_FROM_SYMBOL = "fSym"
        private const val EMPTY_STRING = ""

        @JvmStatic
        fun newInstance(fromSymbol: String?): Fragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(PARAM_FROM_SYMBOL, fromSymbol)
                }
            }
        }
    }
}