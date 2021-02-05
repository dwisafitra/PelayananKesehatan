package com.tempatpelayanankesehatan.tpk.network.response

import com.tempatpelayanankesehatan.tpk.network.model.Results
import com.google.gson.annotations.SerializedName

data class ResultNearby(

        @SerializedName("results")
        var results: ArrayList<Results>?

)