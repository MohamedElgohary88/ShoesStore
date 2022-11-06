package com.example.shoesstore.viewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.buttonLogin.setOnClickListener {
            goToWelcomeFragment()
        }
        binding.buttonSignup.setOnClickListener {
            goToWelcomeFragment()
        }
        return binding.root
    }

    // goToWelcomeFragment
    private fun goToWelcomeFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

}