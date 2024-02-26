package com.nels.master.rickandmortydemo.data.remote

import com.nels.master.rickandmortydemo.data.remote.dto.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiRickAndMortyService {

    @GET("/api/character/?page=1")
    suspend fun getDataRickAndMorty():Response<RickAndMortyResponse>

}