package com.example.crudparcialretrofit.interfaces;

import com.example.crudparcialretrofit.model.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CrudInterface {
    @GET("Empleado")
    Call<List<Empleado>> getAll();
}
