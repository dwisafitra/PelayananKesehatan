package com.tempatpelayanankesehatan.tpk.network.model

import com.google.gson.annotations.SerializedName

data class Review(
        @SerializedName("isi_komentar")
        var isiKomentar: String? = "",
        @SerializedName("id_user")
        var idUser: String? = ""
)