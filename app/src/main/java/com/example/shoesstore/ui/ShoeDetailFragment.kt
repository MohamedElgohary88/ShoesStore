package com.example.shoesstore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.R
import com.example.shoesstore.databinding.FragmentShoeDetailBinding
import com.example.shoesstore.model.Shoes
import com.example.shoesstore.viewModel.MainViewModel


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // used DataBinding

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        // saveData
        binding.viewModel =  Shoes()


        binding.buttonSave.setOnClickListener {
           val  binding_data = binding.viewModel
            val name = binding_data?.name
            val size = binding_data?.size
            val model = binding_data?.model
            val description = binding_data?.description
        viewModel.saveShoe(name!!, model!!, size!!, description!!)

            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        // goToShoesListFragment
        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }
}