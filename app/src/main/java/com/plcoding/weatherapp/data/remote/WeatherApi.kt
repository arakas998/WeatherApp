package com.plcoding.weatherapp.data.remote
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {


    @GET( value = "v1/forecast?latitude=44.8683&longitude=13.8481&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m,pressure_msl")
    suspend fun getWeatherData (
        @Query( value =  "latitude") lat: Double,
        @Query( value = "Longitude") long: Double
    ): WeatherDto
}