package com.honeycomb.imgflipapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResponse (
    @SerializedName("memes")
    var memes: List<Memes>,

): Parcelable

@Parcelize
data class Memes (
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("width")
    var width: Int,
    @SerializedName("height")
    var height: Int,
    @SerializedName("box_count")
    var box_count: Int
): Parcelable