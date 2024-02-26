package com.nels.master.rickandmortydemo

import com.nels.master.rickandmortydemo.data.remote.dto.RickAndMortyResponse

data class MainState(
    val showSplash: Boolean = false,
    val data:RickAndMortyResponse? = null,
    val isSuccess:Boolean = false
)

