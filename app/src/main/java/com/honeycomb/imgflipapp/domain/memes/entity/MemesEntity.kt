package com.honeycomb.imgflipapp.domain.memes.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.honeycomb.imgflipapp.data.DataResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemesEntity (
    var success: String,
    var data: DataResponse,
): Parcelable