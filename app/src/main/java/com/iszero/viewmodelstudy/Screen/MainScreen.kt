package com.iszero.viewmodelstudy.Screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iszero.viewmodelstudy.ViewModel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel, modifier: Modifier) {
    val data = viewModel.data.observeAsState(initial = "")
    //ui에 바로 반영되게 하려면 observeAsState 사용 initial 뒤는 초기값
    //data.value로 접근하면 값만 불러오므로 바로 ui에 반영안됨

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        var (text, setValue) = remember { mutableStateOf("") }
        TextField(value = text, onValueChange = setValue)
        Button(onClick = { viewModel.updateData(text) }) {
            Text(text = "Update")
            Log.d("MainScreen", "MainScreen: ${data.value}")
        }
        Text(text = data.value ?: "")//data가 null이면 "" 으로 표시
    }
}
