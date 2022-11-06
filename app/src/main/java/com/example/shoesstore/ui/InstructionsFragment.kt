package com.example.shoesstore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentInstructionsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        // goToShoesList
        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }
        return binding.root
    }
}