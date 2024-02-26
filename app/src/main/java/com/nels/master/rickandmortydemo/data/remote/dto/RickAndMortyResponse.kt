package com.nels.master.rickandmortydemo.data.remote.dto

import com.nels.master.rickandmortydemo.domian.models.Info
import com.nels.master.rickandmortydemo.domian.models.Result

data class RickAndMortyResponse(
    val info: Info,
    val results: List<Result>
)

