package com.iszero.viewmodelstudy.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val _data = MutableLiveData<String>()
    val data:LiveData<String> get() = _data

    fun updateData(newData: String){
        _data.value = newData
        Log.d("MainViewModel", "updateData: $newData")
    }
}