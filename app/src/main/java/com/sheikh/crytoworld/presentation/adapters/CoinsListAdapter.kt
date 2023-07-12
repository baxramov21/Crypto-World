package com.sheikh.crytoworld.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.databinding.CoinItemBinding
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity

class CoinsListAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinListViewHolder>() {

    var coinClickListener: CoinClickListener? = null

    private val differ = AsyncListDiffer(this, CoinsListDiffCallback())

    var coinsList: List<CoinInfoEntity>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    interface CoinClickListener {
        fun onCoinClick(item: CoinInfoEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CoinListViewHolder {
        val binding = CoinItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        val coin: CoinInfoEntity = coinsList[position]
        val binding = holder.coinItemBinding
        with(binding) {
            with(coin) {
                val timeTemplate = context.getString(R.string.time_template)
                val coinNameTemplate = context.getString(R.string.currency_template)

                textViewCoinName.text = String.format(coinNameTemplate, fromSymbol, toSymbol)
                textViewCoinPrice.text = price.toString()
                textViewCoinPriceLastUpdateTime.text =
                    String.format(timeTemplate, lastUpdate)

                Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.cryptocurrencies)
                    .into(imageViewCoinImage)

                holder.itemView.setOnClickListener {
                    coinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    override fun getItemCount() = coinsList.size

    override fun getItemViewType(position: Int): Int {
        return ITEM_VIEW_TYPE
    }

    companion object {
        const val ITEM_VIEW_TYPE = 1
        const val RECYCLER_VIEW_POOL = 15
    }
}