package com.example.testingapplication.signup

import android.os.Handler
import com.example.testingapplication.api.BaseDataSource
import java.util.regex.Pattern

class SignUpRepository : SignupContract.DataSource {

    private val validEmailAddressRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)!!
    private fun validate(emailStr: String): Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }

    override fun signUp(name: String, email: String, password: String, task: BaseDataSource.Task<String>) {

        if (validate(email)) {
            task.onError("Email id is not valid")
        }

        Handler().post {
            task.onResponse("Sign up success.")
        }
    }
}