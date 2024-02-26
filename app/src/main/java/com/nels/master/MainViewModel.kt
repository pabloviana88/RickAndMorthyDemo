package com.nels.master

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nels.master.rickandmortydemo.MainState
import com.nels.master.rickandmortydemo.domian.ManagerRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MainViewModel:ViewModel() {

    //manejo de estados
    private val _uiState = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uiState.asStateFlow()



    private val managerRequest = ManagerRequest()

    fun getList(){
        viewModelScope.launch {
            val rickAndMortyResponse = managerRequest.getDataRickAndMorty()

            rickAndMortyResponse?.let { dataResponse ->
                _uiState.update { currentState ->
                    currentState.copy(
                       data = dataResponse
                    )
                }
            }?: run{
                _uiState.update { currentState ->
                    currentState.copy(
                        data = null,
                        isSuccess = false,

                    )
                }
            }
        }
    }

}