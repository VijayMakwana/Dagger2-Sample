package com.dagger2sample

import com.google.gson.annotations.SerializedName


data class PostResp(
        @SerializedName("data") val data: List<Data>
)

data class Data(
        @SerializedName("userId") val userId: String,
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
)