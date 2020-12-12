package com.fawwaz.motor.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fawwaz.motor.R
import com.fawwaz.motor.data.model.AuthUser
import com.fawwaz.motor.databinding.ActivityAuthBinding
import com.fawwaz.motor.ui.home.MainActivity

class AuthActivty : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun  onSucess(user: AuthUser?){
    val intent = Intent( this, MainActivity::class.java )
        startActivity(intent)
        finish()
    }
}