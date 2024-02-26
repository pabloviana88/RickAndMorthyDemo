package com.nels.master.rickandmortydemo.domian

import com.nels.master.rickandmortydemo.data.remote.ApiManager
import com.nels.master.rickandmortydemo.data.remote.dto.RickAndMortyResponse

class ManagerRequest {

    //Instancia del service
    private val api = ApiManager().getRickAndMortyService()


    suspend fun getDataRickAndMorty():RickAndMortyResponse?{
        return try {
            val response = api.getDataRickAndMorty()
            if (response.isSuccessful){
                response.body()
            }else{
                null
            }
        }catch (ex:Exception){
            null
        }
    }
}