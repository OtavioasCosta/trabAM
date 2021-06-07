package br.com.cotemig.trabalhoam.services

import br.com.cotemig.trabalhoam.model.ListArtistas
import retrofit2.Call
import retrofit2.http.GET

interface ServiceArtistas {

    @GET("d6f123e0-e0cc-49c0-9966-13a95447fe4d")
    fun obterListaArtistas(): Call<ListArtistas>
}