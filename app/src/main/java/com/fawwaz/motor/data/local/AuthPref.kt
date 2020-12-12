package com.fawwaz.motor.data.local

import android.content.Context
import android.content.SharedPreferences
import com.fawwaz.motor.data.model.ActionState
import com.fawwaz.motor.data.model.AuthUser
import com.fawwaz.motor.util.getObject
import com.fawwaz.motor.util.putObject

class AuthPref(val context:Context) {
    private val sp: SharedPreferences by lazy {
        context.getSharedPreferences(AuthPref::class.java.name,Context.MODE_PRIVATE)
    }

    private companion object {
        const val AUTH_USER = "auth_user"
        const val IS_LOGIN = "is_login"
    }

    var authUser: AuthUser?
    get() = sp.getObject(AUTH_USER)
    private set(value) = sp.edit().putObject(AUTH_USER, value).apply()

    var isLogin: Boolean
    get() = sp.getBoolean(IS_LOGIN, false)
    private set(value) = sp.edit().putBoolean(IS_LOGIN, value).apply()

    suspend fun login(email: String, passsword: String):ActionState<AuthUser>{
        val user = authUser
        return if (user == null) {
            ActionState(message= "Anda Belum Terdaftar" , isSucces = false)
        }else if (email.isBlank() || passsword.isBlank()) {
            isLogin = true
            return ActionState(authUser, message = "Anda Berhasil Login")
        } else {
            ActionState(message = "Email atau Password Salah", isSucces = false)
        }
    }
suspend fun register(user: AuthUser): ActionState<AuthUser> {
    return if (user.email.isBlank() ||user.password.isBlank ()) {
        ActionState(message = "Email dan password tidak boleh kosong", isSucces = false)
    } else {
        authUser = user
        ActionState(user, message = "Anda berhasil daftar")
    }
}

suspend fun logout(): ActionState<Boolean> {
    isLogin = false
    return ActionState(true, message = "Anda berhasil logout")
}
}
