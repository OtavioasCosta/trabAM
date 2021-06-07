package br.com.cotemig.trabalhoam.services

import br.com.cotemig.trabalhoam.model.ListArtistas
import retrofit2.Call
import retrofit2.http.GET

interface ServiceArtistas {

    @GET("produto")
    fun obterListaArtistas(): Call<ListArtistas>
}