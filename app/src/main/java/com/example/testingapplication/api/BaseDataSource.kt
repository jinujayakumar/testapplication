package com.example.testingapplication.api

interface BaseDataSource {

    interface Task<T> {
        fun onResponse(response: T)
        fun onError(error: String)
    }
}