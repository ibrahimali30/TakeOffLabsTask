package com.ibrahim.takeofflabstask.feature.data.model

import com.google.gson.annotations.SerializedName

data class GenresResponse constructor(
        @SerializedName("status") val status: String,
        @SerializedName("message") val message: String
)
