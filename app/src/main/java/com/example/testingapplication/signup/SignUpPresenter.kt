package com.example.testingapplication.signup

import android.text.TextUtils
import com.example.testingapplication.api.BaseDataSource

class SignUpPresenter(var view: SignupContract.View?,
                      var dataSource: SignupContract.DataSource?) :SignupContract.Presenter {


    override fun signUp(name: String?, email: String?, password: String?) {
        if (isEmpty(name)){
            view?.showError("Name cannot be empty",SignupContract.View.Type.TYPE_NAME)
        }
        if (isEmpty(email)){
            view?.showError("Email cannot be empty",SignupContract.View.Type.TYPE_EMAIL)
        }
        if (isEmpty(email)){
            view?.showError("Password cannot be empty",SignupContract.View.Type.TYPE_PASSWORD)
        }

        if (isEmpty(name)||
                TextUtils.isEmpty(email)||
                TextUtils.isEmpty(password)){
            return
        }
        dataSource?.signUp(name!!,email!!,password!!,object :BaseDataSource.Task<String>{
            override fun onResponse(response: String) {
                view?.onSuccessSignUp(response)
            }

            override fun onError(error: String) {
                view?.onSignUpError(error)
            }
        })
    }

    private fun isEmpty(str: CharSequence?): Boolean {
        return str == null || str.isEmpty()
    }
}