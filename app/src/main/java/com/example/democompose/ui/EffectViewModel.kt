package com.example.democompose.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EffectViewModel : ViewModel(){
    val state = mutableStateOf<StateMaintain>(StateMaintain.Loading)
    fun loadData(){
        Log.d("TAG", "loadData==== LoginViewModel")
        state.value = StateMaintain.Loading
        viewModelScope.launch {
            delay(2000)
            state.value = StateMaintain.Success(
                timesTemp = System.currentTimeMillis(),
                validity = 10000
            )
        }
    }
}
sealed class StateMaintain{
    object Loading: StateMaintain()
    data class Success(
        val data : String = "Loaded Data",
        val timesTemp : Long,
        val validity: Long
    ): StateMaintain()
    data class Error(
        val errorDetails:String
    ): StateMaintain()
}