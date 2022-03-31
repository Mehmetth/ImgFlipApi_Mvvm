package com.honeycomb.imgflipapp.data.memes.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.honeycomb.imgflipapp.data.DataResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemesResponse (
    @SerializedName("success")
    var success: String,
    @SerializedName("data")
    var data: DataResponse,
): Parcelable