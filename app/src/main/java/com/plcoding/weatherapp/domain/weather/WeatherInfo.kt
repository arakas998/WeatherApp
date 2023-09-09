package com.plcoding.weatherapp.domain.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherdata: WeatherData?,
    var klima1: Boolean,
    var klima2: Boolean,
    var klima3: Boolean,
    var klima4: Boolean,
    var klima5: Boolean,
)
