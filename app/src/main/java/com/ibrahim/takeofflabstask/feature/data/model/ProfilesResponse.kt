package com.ibrahim.takeofflabstask.feature.data.model

import com.google.gson.annotations.SerializedName

data class ProfilesResponse constructor(
        @SerializedName("profiles") val profiles: List<Profile>
)
