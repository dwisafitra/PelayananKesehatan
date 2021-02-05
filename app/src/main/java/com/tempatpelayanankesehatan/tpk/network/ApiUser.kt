package com.tempatpelayanankesehatan.tpk.network

import com.tempatpelayanankesehatan.tpk.network.model.Review
import com.tempatpelayanankesehatan.tpk.network.model.User
import com.tempatpelayanankesehatan.tpk.network.response.ResultLogin
import com.tempatpelayanankesehatan.tpk.network.response.ResultRegister
import com.tempatpelayanankesehatan.tpk.network.response.ResultReview
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiUser {

    @POST("user/register")
    suspend fun register(
            @Body user: User
    ): Response<ResultRegister>

    @POST("user/login")
    suspend fun login(
            @Body user: User
    ): Response<ResultLogin>

    @POST("review")
    suspend fun uploadReview(
            @Body review: Review
    ): Response<ResultReview>

}