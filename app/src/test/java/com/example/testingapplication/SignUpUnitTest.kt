package com.example.testingapplication

import com.example.testingapplication.signup.SignUpPresenter
import com.example.testingapplication.signup.SignUpRepository
import com.example.testingapplication.signup.SignupContract
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SignUpUnitTest {

    @Mock
    @JvmField
    var view: SignupContract.View? = null

    private lateinit var presenter: SignUpPresenter

    @Before
    fun onBefore() {
        presenter = SignUpPresenter(view, SignUpRepository())
    }

    @Test
    fun checkUsernameError() {
        presenter.signUp(null,"lkflkjdsflds","kldsjfldsflds")
    }

    @After
    fun onAfter() {

    }
}