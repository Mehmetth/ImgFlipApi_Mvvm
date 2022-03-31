package com.honeycomb.imgflipapp.domain.memes

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntity (
    var memes: List<Memes>,
    ): Parcelable

@Parcelize
data class Memes (
    var id: String,
    var name: String,
    var url: String,
    var width: Int,
    var height: Int,
    var box_count: Int
): Parcelable