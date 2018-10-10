package com.example.testingapplication.signup

import androidx.annotation.IntDef
import com.example.testingapplication.api.BaseDataSource

interface SignupContract {


    @IntDef(View.Type.TYPE_NAME, View.Type.TYPE_EMAIL, View.Type.TYPE_PASSWORD)
    @Retention(AnnotationRetention.SOURCE)
    annotation class SignUpType

    interface View {

        object Type {
            const val TYPE_NAME = 1
            const val TYPE_EMAIL = 2
            const val TYPE_PASSWORD = 3
        }

        fun showError(errorMessage: String, @SignUpType type: Int)

        fun onSignUpError(errorMessage: String)

        fun onSuccessSignUp(message: String)

    }

    interface Presenter {

        fun signUp(name: String?, email: String?, password: String?)

    }

    interface DataSource :BaseDataSource{

        fun signUp(name: String, email: String, password: String,task: BaseDataSource.Task<String>)

    }
}