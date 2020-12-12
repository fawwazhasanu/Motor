package com.fawwaz.motor.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.fawwaz.motor.R
import com.fawwaz.motor.data.repository.AuthRepository
import com.fawwaz.motor.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    val parent: AuthActivty by lazy { activity as AuthActivty }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

    private fun observe() {
        viewModel.authLogin.observe(viewLifecycleOwner){
            if (it.isConsumed) {
                Log.i( "Login", "isConsumed")
            }else if (!it.isSucces) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
                parent.onSucess(it.data)
            }
            it.isConsumed = true
        }

    }
}