package com.nels.master.rickandmortydemo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nels.master.MainViewModel
import com.nels.master.rickandmortydemo.ui.components.Item

@Composable
fun MainScreen(mainViewModel: MainViewModel) {

    mainViewModel.getList()
    val list = mainViewModel.uiState.collectAsState().value.data?.results ?: emptyList()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = list   , itemContent = { element ->
                Item(element)
                Spacer(modifier = Modifier.size(16.dp))
            })
        }
    }
}