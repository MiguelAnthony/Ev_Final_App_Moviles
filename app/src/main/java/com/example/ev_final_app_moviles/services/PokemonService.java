package com.example.ev_final_app_moviles.services;

import com.example.ev_final_app_moviles.Clases.Pokemon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface PokemonService {
    @GET("pokemons/N00036571")
    Call<List<Pokemon>> getAll();

    @POST("pokemons/N00036571/crear")
    Call<Pokemon> create(@Body Pokemon pokemon);
}
