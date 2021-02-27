package com.ibrahim.takeofflabstask.feature.data.model

import com.google.gson.annotations.SerializedName

data class Profile constructor(
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val first_name: String,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("is_match") val is_match: Boolean,
    @SerializedName("country") val country: String,
    @SerializedName("city") val city: String,
    @SerializedName("photos") val photos: List<String>

)