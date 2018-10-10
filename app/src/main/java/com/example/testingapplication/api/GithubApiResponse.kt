package com.example.testingapplication.api

import retrofit2.Call
import retrofit2.http.GET

interface GithubApiResponse {

    @GET("/jinujayakumar/7861181cc56c56a0ea0d152854c12f1c/raw/648d5d2ecec60c5cc4ca9ad97286db2ba2f90cba/SampleGson.json")
    fun getResponse(): Call<DotResponse>
}
