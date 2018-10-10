package com.example.testingapplication.login

import com.example.testingapplication.api.BaseDataSource

class LoginPresenter(var view: LoginContract.View?, var dataSource: LoginContract.DataSource) : LoginContract.Presenter {


    override fun login(username: String?, password: String?) {
        if (isDataValid(username, password)) return
        dataSource.login(username!!, password!!, task = object : BaseDataSource.Task<String> {
            override fun onResponse(response: String) {
                view?.showSuccess(response)
                view?.launchHomeScreen()
            }

            override fun onError(error: String) {
                view?.showError(error)
            }
        })
    }

    private fun isDataValid(username: String?, password: String?): Boolean {
        if (isEmpty(username)) {
            view?.showError("Username is empty", LoginContract.LoginType.USER_NAME)
        }

        if (isEmpty(password)) {
            view?.showError("Password is empty", LoginContract.LoginType.PASSWORD)
        }

        if (isEmpty(username) || isEmpty(password)) {
            return true
        }
        view?.clearError()
        return false
    }

    private fun isEmpty(str: CharSequence?): Boolean {
        return str == null || str.isEmpty()
    }
}