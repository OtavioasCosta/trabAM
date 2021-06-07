package br.com.cotemig.trabalhoam.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    // instanciando o retrofit para ser usado na URL e
    // Conversor JSON > Classe e Classe > JSON
    private val retrofit = Retrofit.Builder().
    baseUrl("https://api.fluo.work/v1/").
    addConverterFactory(GsonConverterFactory.create()).
    build()

    fun accountService() : AccountService{
        return retrofit.create(AccountService::class.java)
    }

    private val retrofitMockup = Retrofit.Builder().baseUrl("https://mockup.fluo.app/v1/").addConverterFactory(GsonConverterFactory.create()).build()

    fun serviceArtistas(): ServiceArtistas{
        return retrofitMockup.create(ServiceArtistas::class.java)
    }
}