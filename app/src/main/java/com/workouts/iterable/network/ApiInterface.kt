package com.workouts.iterable.network

import com.workouts.iterable.network.model.WorkoutsResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("Accept: application/json")
    @GET("api/workouts")
    suspend fun getWorkouts(): WorkoutsResponse

}