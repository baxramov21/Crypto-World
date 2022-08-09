package com.sheikh.crytoworld.pojos

import android.media.Rating
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinInfo (

    @SerializedName("Id")
    @Expose
     val id: String? = null,

    @SerializedName("Name")
    @Expose
     val name: String? = null,

    @SerializedName("FullName")
    @Expose
     val fullName: String? = null,

    @SerializedName("Internal")
    @Expose
     val internal: String? = null,

    @SerializedName("ImageUrl")
    @Expose
     val imageUrl: String? = null,

    @SerializedName("Url")
    @Expose
     val url: String? = null,

    @SerializedName("Algorithm")
    @Expose
     val algorithm: String? = null,

    @SerializedName("ProofType")
    @Expose
     val proofType: String? = null,

    @SerializedName("Rating")
    @Expose
     val rating: Rating? = null,

    @SerializedName("NetHashesPerSecond")
    @Expose
     val netHashesPerSecond: Int? = null,

    @SerializedName("BlockNumber")
    @Expose
     val blockNumber: Int? = null,

    @SerializedName("BlockTime")
    @Expose
     val blockTime: Int? = null,

    @SerializedName("BlockReward")
    @Expose
     val blockReward: Int? = null,

    @SerializedName("AssetLaunchDate")
    @Expose
     val assetLaunchDate: String? = null,

    @SerializedName("MaxSupply")
    @Expose
     val maxSupply: Int? = null,

    @SerializedName("Type")
    @Expose
     val type: Int? = null,

    @SerializedName("DocumentType")
    @Expose
     val documentType: String? = null,
)