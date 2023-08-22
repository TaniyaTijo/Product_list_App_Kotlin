package com.example.newapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MyViewModel: ViewModel() {
    var response = MutableLiveData<List<Result>>()

    var api = RetroConfig().getInstance().create(ProductApi::class.java)


    fun getData() {
        try{
            viewModelScope.launch{
                var res = api.getAllProducts()
                response.value=res.body()?.products
            }
        }catch (e:Exception){
            println(e.message)
        }
    }
}