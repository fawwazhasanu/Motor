package com.fawwaz.motor.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fawwaz.motor.R
import com.fawwaz.motor.databinding.ActivityMainBinding
import com.fawwaz.motor.ui.auth.AuthActivty
import com.fawwaz.motor.ui.auth.MotorAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            MotorAuth.logout(this){
              startActivity(Intent(this,AuthActivty::class.java))
                finish()
            }
        }
    }
}