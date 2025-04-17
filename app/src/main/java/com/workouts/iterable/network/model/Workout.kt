package com.workouts.iterable.network.model

import com.workouts.iterable.network.RetrofitClient

data class Workout(
    val category: String,
    val description: String,
    val difficulty: String,
    val duration: Int,
    val id: String,
    val imageHeight: Int,
    val imageUrl: String,
    val imageWidth: Int,
    val instructor: String,
    val title: String
) {

    val imageLink = "${RetrofitClient.baseUrl}$imageUrl"

}