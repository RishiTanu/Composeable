package com.example.democompose.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheets() {
    Box(modifier = Modifier.fillMaxSize()) {

        val sheetState = rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden
        )
        /*val sheetState = rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden
        )*/
        val coroutineScope = rememberCoroutineScope()
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                Text(
                    text = "BottomSheet",
                    fontSize = 15.sp
                )
                Text(
                    text = "BottomSheet",
                    fontSize = 15.sp
                )
                Text(
                    text = "BottomSheet",
                    fontSize = 15.sp
                )
                Text(
                    text = "BottomSheet",
                    fontSize = 15.sp
                )
                Text(
                    text = "BottomSheet",
                    fontSize = 15.sp
                )

            },
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    sheetState.show()
                }
            }) {
                Text(text = "Show Bottom Seet")
            }
        }
    }
}

@Composable
fun Effects(viewModel: EffectViewModel = EffectViewModel()) {
    val state = viewModel.state.value

    //when i want to call it again and again
    var time by remember(System.currentTimeMillis()) {
        mutableLongStateOf(System.currentTimeMillis())
    }
    var lastchecked by remember{
        mutableLongStateOf(System.currentTimeMillis())
    }

    LaunchedEffect(time){
        delay(1000)
        time = System.currentTimeMillis()
    }

    val isValid: Boolean by remember(state,(time - lastchecked) > 1000) {
        derivedStateOf {
            Log.d("TAG", "Effects======= loaded data")
            lastchecked = time
            state is StateMaintain.Success && (time - state.timesTemp) < state.validity
        }
    }
    //it will call composable 1 time
    /*LaunchedEffect(Unit){
        viewModel.loadData()
    }*/
    //same it will do same
    LaunchedEffect(isValid) {
        if (!isValid)
            viewModel.loadData()
    }

    when (state) {
        is StateMaintain.Loading -> {
            Text(text = "Loading")
        }

        is StateMaintain.Success -> {
            Text(text = state.data)
        }

        is StateMaintain.Error -> {
            Text(text = state.errorDetails)
        }
    }
}

var mutableList: MutableList<Int> = mutableListOf()
fun addition(n1: Int, n2: Int): Int {
    mutableList.add(n1)
    mutableList.add(n2)
    return n1 + n2
}