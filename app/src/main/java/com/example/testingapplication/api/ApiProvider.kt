package com.example.testingapplication.api

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


object ApiProvider {

    val apiResponse: GithubApiResponse
        get() {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://gist.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(GithubApiResponse::class.java)
        }
}