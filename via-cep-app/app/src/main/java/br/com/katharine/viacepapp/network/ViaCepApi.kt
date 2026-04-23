package br.com.katharine.viacepapp.network

import br.com.katharine.viacepapp.model.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("{cep}/json/")
    suspend fun buscarCep(
        @Path("cep") cep: String
    ): CepResponse
}