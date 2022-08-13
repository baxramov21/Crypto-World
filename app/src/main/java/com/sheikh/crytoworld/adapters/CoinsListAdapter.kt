package com.sheikh.crytoworld.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sheikh.crytoworld.R
import com.sheikh.crytoworld.pojos.top_coins_list.coin_info.CoinInfo
import kotlinx.android.synthetic.main.coin_item.view.*

class CoinsListAdapter(var coinsList: ArrayList<CoinInfo> = ArrayList()) :

    RecyclerView.Adapter<CoinsListAdapter.CoinListViewHolder>() {

    private lateinit var context: Context

    class CoinListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCoinImage = itemView.imageViewCoinImage
        val textViewCoinName = itemView.textViewCoinName
        val textViewCoinPrice = itemView.textViewCoinPrice
        val textViewCoinPriceLastUpdateTime = itemView.textViewLastUpdateTime
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        iewType: Int): CoinListViewHolder {
        context = parent.context
        val result = LayoutInflater.from(context).inflate(R.layout.coin_item, parent, false)
        return CoinListViewHolder(result)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        val coin: CoinInfo = coinsList[position]
        with(holder) {

//            // set image of coin
//            Glide.with(context)
//                .load(coin.imageUrl)
//                .placeholder(R.drawable.bitcoin)
//                .error(R.drawable.not_found)
//                .into(imageViewCoinImage);
//
//            // set name of coin
//            textViewCoinName.text = coin.fullName
//
//            // set price of coin
//            textViewCoinPrice.text = coin.id
//
//            // set coin price update time
//            textViewCoinPriceLastUpdateTime.text = "Toaday"

        }
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }
}