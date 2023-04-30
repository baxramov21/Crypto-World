package com.sheikh.crytoworld.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.data.model.coin_full_info.CoinPriceInfo
import kotlinx.android.synthetic.main.coin_item.view.*

class CoinsListAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinsListAdapter.CoinListViewHolder>() {

    var coinClickListener: CoinClickListener? = null

    var coinsList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface CoinClickListener {
        fun onCoinClick(coin: CoinPriceInfo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CoinListViewHolder {
        val result = LayoutInflater.from(context).inflate(R.layout.coin_item, parent, false)
        return CoinListViewHolder(result)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        val coin: CoinPriceInfo = coinsList[position]
        with(holder) {
            with(coin) {

                val timeTemplate = context.getString(R.string.time_template)
                val coinNameTemplate = context.getString(R.string.currency_template)

                // set name of coin
                textViewCoinName.text = String.format(coinNameTemplate, fromSymbol, toSymbol)

                // set price of coin
                textViewCoinPrice.text = price.toString()

                // set coin price update time
                textViewCoinPriceLastUpdateTime.text =
                    String.format(timeTemplate, getLastUpdatedTime())

                // set image of coin
                Glide.with(context)
                    .load(getFullImageURL())
                    .error(R.drawable.not_found)
                    .into(imageViewCoinImage)

                // set listener to each coin element
                itemView.setOnClickListener {
                    coinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    override fun getItemCount() = coinsList.size

    inner class CoinListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCoinImage: ImageView = itemView.imageViewCoinImage
        val textViewCoinName: TextView = itemView.textViewCoinName
        val textViewCoinPrice: TextView = itemView.textViewCoinPrice
        val textViewCoinPriceLastUpdateTime: TextView = itemView.textViewLastUpdateTime
    }
}