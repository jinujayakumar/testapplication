package com.example.testingapplication.mock

import com.example.testingapplication.api.BaseDataSource
import com.example.testingapplication.login.LoginContract
import java.util.regex.Pattern

class LoginDataSource : LoginContract.DataSource {

    private val validEmailAddressRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)!!

    override fun login(username: String, password: String, task: BaseDataSource.Task<String>) {
        if (!validate(username)) {
            task.onError("Email is not valid")
            return
        }

        task.onResponse("Login success")

    }

    private fun validate(emailStr: String): Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }
}