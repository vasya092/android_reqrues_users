package com.example.reqresusers.service

import com.example.reqresusers.data.UsersListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://reqres.in/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ReqresApiService {
    @GET("users")
    suspend fun getUsers(): UsersListResponse
}

object UsersApi {
    val retrofitService : ReqresApiService by lazy {
        retrofit.create(ReqresApiService::class.java)
    }
}