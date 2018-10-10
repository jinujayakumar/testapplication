package com.example.testingapplication.login

import androidx.annotation.IntDef
import com.example.testingapplication.api.BaseDataSource

interface LoginContract {

    @IntDef(LoginType.USER_NAME,LoginType.PASSWORD)
    @Retention(AnnotationRetention.SOURCE)
    annotation class LoginTypes

    object LoginType {
        const val USER_NAME = 1
        const val PASSWORD = 2
    }


    interface View {

        fun showError(errorMsg: String)

        fun showError(errorMsg: String,@LoginTypes type: Int)

        fun showSuccess(successMsg: String)

        fun launchHomeScreen()

        fun launchSignUpActivity()

        fun clearError()
    }


    interface Presenter {

        fun login(username: String?, password: String?)
    }

    interface DataSource :BaseDataSource {

        fun login(username: String, password: String,task: BaseDataSource.Task<String>)
    }
}