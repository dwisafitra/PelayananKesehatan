package com.tempatpelayanankesehatan.tpk.network.response

import com.google.gson.annotations.SerializedName
import com.tempatpelayanankesehatan.tpk.network.model.User

data class ResultLogin(
        @SerializedName("data")
        var data: User? = null
)