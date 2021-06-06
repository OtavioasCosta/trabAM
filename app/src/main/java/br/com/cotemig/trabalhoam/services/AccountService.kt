package br.com.cotemig.trabalhoam.services

import br.com.cotemig.trabalhoam.model.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountService {
    @POST("account")
    fun create(@Body account: Account): Call<Account>

    @POST("account/forgot")
    fun forgot(@Body account: Account): Call<Void>
    // Para os casos que a API não retornar JSON nenhum utilize o Void

    @POST("account/auth")
    fun auth(@Body account: Account): Call<Account>
}