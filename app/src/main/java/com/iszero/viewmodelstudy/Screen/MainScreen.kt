package com.iszero.viewmodelstudy.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iszero.viewmodelstudy.ViewModel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel,modifier: Modifier) {
    val data:String = viewModel.data.value.toString()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        var text by remember { mutableStateOf("") }
        TextField(value = text, onValueChange = { text = it })
        Button(onClick = { viewModel.updateData(text)}) {
        }
        Text(text = if (data == null) "No Data" else data)
    }
}
