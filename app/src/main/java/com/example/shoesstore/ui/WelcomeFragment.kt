package com.example.shoesstore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // used DataBinding
       val binding : FragmentWelcomeBinding =
           DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,container, false)
        binding.btnInstruction.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
        return binding.root
    }
}