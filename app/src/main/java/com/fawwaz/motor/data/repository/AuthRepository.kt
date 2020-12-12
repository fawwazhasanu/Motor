package com.fawwaz.motor.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.fawwaz.motor.data.local.AuthPref
import com.fawwaz.motor.data.model.ActionState
import com.fawwaz.motor.data.model.AuthUser

class AuthRepository(val context: Context) {
    private  val authPref: AuthPref by lazy { AuthPref(context ) }

    val authUser = MutableLiveData<AuthUser>(authPref.authUser)
    val isLogin = MutableLiveData<Boolean>(authPref.isLogin)

    suspend fun  login (email: String, paswword:String) : ActionState<AuthUser> {
        return authPref.login(email, paswword)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser>{
        return authPref.register(user)
    }

    suspend fun logout() : ActionState<Boolean> {
        return authPref.logout()
    }
}