package com.fawwaz.motor.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fawwaz.motor.R
import com.fawwaz.motor.data.repository.AuthRepository
import com.fawwaz.motor.databinding.FragmentSplashBinding
import kotlinx.coroutines.*

class SplashFragment : Fragment() {
    val parent: AuthActivty by lazy { activity as AuthActivty }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater,container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init() {
       CoroutineScope(Dispatchers.IO).launch {
           delay(2000)
           withContext(Dispatchers.Main) {
               if (viewModel.isLogin.value == true) {
                   parent.onSucess(viewModel.authUser.value)
               }else {
                   findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
               }
           }
       }
    }
}