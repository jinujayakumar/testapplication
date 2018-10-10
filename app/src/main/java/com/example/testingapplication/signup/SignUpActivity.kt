package com.example.testingapplication.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapplication.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), SignupContract.View {

    private lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        presenter = SignUpPresenter(this, SignUpRepository())
        btnSignUp.setOnClickListener {
            presenter.signUp(etName.text.toString(), etEmail.text.toString(), etPassword.text.toString())
        }
    }

    override fun showError(errorMessage: String, type: Int) {
        when (type) {
            SignupContract.View.Type.TYPE_NAME -> etName.error = errorMessage
            SignupContract.View.Type.TYPE_EMAIL -> etEmail.error = errorMessage
            SignupContract.View.Type.TYPE_PASSWORD -> etPassword.error = errorMessage
        }
    }

    override fun onSignUpError(errorMessage: String) {
        Snackbar.make(btnSignUp, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    override fun onSuccessSignUp(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
