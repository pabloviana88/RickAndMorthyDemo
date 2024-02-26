package com.nels.master.rickandmortydemo.data.remote

import com.nels.master.rickandmortydemo.global.Cons
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    private fun getRetrofit() = Retrofit.Builder().baseUrl(Cons.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getRickAndMortyService():ApiRickAndMortyService{

        val rickAndMortyService = getRetrofit().create(ApiRickAndMortyService::class.java)
        return rickAndMortyService
    }

}