package com.example.shoesstore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.databinding.FragmentShoeListBinding
import com.example.shoesstore.databinding.ShoeItemBinding
import com.example.shoesstore.model.Shoes
import com.example.shoesstore.viewModel.MainViewModel

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        // used lifecycleOwner
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        val viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        // observe on viewModel
        viewModel.shoesList.observe(viewLifecycleOwner) { item ->
            shoeListView(item)
        }

        // goTo ShoeDetailFragment
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }


    private fun shoeListView(item: List<Shoes>?) {
        item?.forEach {
            val bindingView = ShoeItemBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.linearLayout,
                false
            )
            with(bindingView) {
                shoeItemName.text = it.name.toString()
                shoeItemModel.text = it.model.toString()
                shoeItemSize.text = it.size.toString()
                shoeItemDescription.text = it.description.toString()
            }
            binding.linearLayout.addView(bindingView.root)
        }
    }


    // onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    // onOptionsItemSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }
}