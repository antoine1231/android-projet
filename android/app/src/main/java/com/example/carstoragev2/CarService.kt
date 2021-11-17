package com.example.carstoragev2


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface CarService {

    @GET("cars")
    fun getAllCars(): Call<List<Car>>

    @POST("cars")
    fun createCar(@Body car: Car): Call<Car>

    @PUT("cars")
    fun putCarAsFavorite(@Body car:Car): Call<Car>
}