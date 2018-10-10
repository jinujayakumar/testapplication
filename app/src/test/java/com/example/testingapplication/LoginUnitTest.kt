package com.example.testingapplication

import com.example.testingapplication.login.LoginContract
import com.example.testingapplication.login.LoginPresenter
import com.example.testingapplication.mock.LoginDataSource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginUnitTest {


    @Mock
    lateinit var view: LoginContract.View

    private lateinit var presenter: LoginContract.Presenter

    @Before
    fun onBefore() {
        view = mock(LoginContract.View::class.java)
        presenter = LoginPresenter(view, LoginDataSource())
    }


    @Test
    fun loginUserNamePWDError() {
        presenter.login(null, null)
        verify(view)?.showError("Username is empty", LoginContract.LoginType.USER_NAME)
        verify(view)?.showError("Password is empty", LoginContract.LoginType.PASSWORD)
        verify(view, never())?.clearError()
        verify(view, never()).showError("")
        verify(view, never())?.showSuccess("")
        verify(view, never())?.launchHomeScreen()
    }

    @Test
    fun loginFailure() {
        presenter.login("jinu", "jinu")
        verify(view, never())?.showError("Username is empty", LoginContract.LoginType.USER_NAME)
        verify(view, never())?.showError("Password is empty", LoginContract.LoginType.PASSWORD)
        verify(view)?.clearError()
        verify(view).showError("Email is not valid")
        verify(view, never())?.showSuccess("")
        verify(view, never())?.launchHomeScreen()
    }

    @Test
    fun loginSuccess(){
        presenter.login("jinu@jinu.cccc", "jinu")
        verify(view, never())?.showError("Username is empty", LoginContract.LoginType.USER_NAME)
        verify(view, never())?.showError("Password is empty", LoginContract.LoginType.PASSWORD)
        verify(view)?.clearError()
        verify(view, never()).showError("Email is not valid")
        verify(view)?.showSuccess("Login success")
        verify(view)?.launchHomeScreen()
    }

    @After
    fun after() {
        reset(view)
        print(view)
    }
}
