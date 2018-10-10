package com.example.testingapplication.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseViewModel<T> : ViewModel(), Callback<T> {

    var task: Task<T>? = null

    interface Task<T> {
        fun getApi(): Call<T>
        fun onFailure(t: Throwable)
    }

    private lateinit var mutableResponse: MutableLiveData<T>

    fun getApi(): LiveData<T> {
        if (!::mutableResponse.isInitialized) {
            mutableResponse = MutableLiveData()
            loadApi()
        } else {
            if (mutableResponse.value == null) {
                loadApi()
            }
        }
        return mutableResponse
    }

    private fun loadApi() {
        task?.getApi()?.enqueue(this)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.d(this.javaClass.name, t.localizedMessage)
        task?.onFailure(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        Log.d(this.javaClass.name, response.body().toString())
        if (response.isSuccessful && response.body() != null)
            mutableResponse.value = response.body()
    }

}