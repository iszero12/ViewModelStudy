package com.iszero.viewmodelstudy.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val data = MutableLiveData<String>()

    fun updateData(newData: String){
        data.value = newData
        Log.d("MainViewModel", "updateData: $newData")
    }
}