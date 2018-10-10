package com.example.testingapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testingapplication.R
import com.example.testingapplication.home.HomeActivity
import com.example.testingapplication.signup.SignUpActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.login_main.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)
        presenter = LoginPresenter(this, LoginRepository())
        btnLogin.setOnClickListener {
            presenter.login(etUserName.text.toString(), etPwd.text.toString())
        }
    }

    override fun showError(errorMsg: String) {
        Snackbar.make(etUserName, errorMsg, Snackbar.LENGTH_SHORT).show()
    }

    override fun showError(errorMsg: String, type: Int) {
        when (type) {
            LoginContract.LoginType.USER_NAME -> {
                tlUserName.isErrorEnabled = true
                tlUserName.error = errorMsg
            }
            LoginContract.LoginType.PASSWORD -> {
                pwdTIL.isErrorEnabled = true
                pwdTIL.error = errorMsg
            }
        }
    }

    override fun showSuccess(successMsg: String) {
        Toast.makeText(this, successMsg, Toast.LENGTH_SHORT).show()
    }

    override fun launchHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun launchSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    override fun clearError() {
        tlUserName.isErrorEnabled = false
        pwdTIL.isErrorEnabled = false
    }
}
