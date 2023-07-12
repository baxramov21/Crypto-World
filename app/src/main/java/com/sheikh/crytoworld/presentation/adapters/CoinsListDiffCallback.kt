package com.sheikh.crytoworld.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity

class CoinsListDiffCallback : DiffUtil.ItemCallback<CoinInfoEntity>() {

    override fun areItemsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem.lastTradeId == newItem.lastTradeId
    }

    override fun areContentsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem == newItem
    }
}