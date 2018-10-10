package com.example.testingapplication.login

import android.os.Handler
import com.example.testingapplication.api.BaseDataSource
import java.util.regex.Pattern

class LoginRepository : LoginContract.DataSource {


    private val validEmailAddressRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)!!

    override fun login(username: String, password: String, task: BaseDataSource.Task<String>) {
        if (validate(username)) {
            task.onError("Email is not valid")
            return
        }
        Handler().post {
            task.onResponse("Login success")
        }
    }

    private fun validate(emailStr: String): Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }
}