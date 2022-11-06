package com.example.shoesstore.viewModel

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesstore.model.Shoes

// class ViewModel
class MainViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeModel = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    // used LiveData
    var shoesList = MutableLiveData<MutableList<Shoes>>()

    init {
        shoesList.value = ArrayList()
    }

    // saveShoe
    fun saveShoe(name:String, model: String, size: String, description: String) {
        val item_shoes = Shoes(name, model, size, description)
        shoesList.value?.add(item_shoes)
    }
}
