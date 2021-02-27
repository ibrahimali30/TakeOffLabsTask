package com.ibrahim.takeofflabstask.feature.data.model

import com.google.gson.annotations.SerializedName

data class GenresResponse constructor(
        @SerializedName("profiles") val profiles: List<Profile>
)
