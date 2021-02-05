package com.tempatpelayanankesehatan.tpk.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
        @SerializedName("id_user")
        var idUser: String? = "",
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("email")
        var email: String? = "",
        @SerializedName("password")
        var password: String? = ""
) : Parcelable