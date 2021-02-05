package com.tempatpelayanankesehatan.tpk.network.response

import com.tempatpelayanankesehatan.tpk.network.model.Result
import com.google.gson.annotations.SerializedName

data class ResultDetails(

        @SerializedName("result")
        var result: Result

)