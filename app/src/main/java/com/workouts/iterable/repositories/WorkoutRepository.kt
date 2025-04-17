package com.workouts.iterable.repositories

import com.workouts.iterable.network.ApiInterface
import com.workouts.iterable.network.model.Workout
import com.workouts.iterable.utils.ApiResult
import com.workouts.iterable.utils.toUserMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WorkoutRepository(private val service: ApiInterface) {

    fun getWorkouts(): Flow<ApiResult<List<Workout>>> = flow {
        try {
            emit(ApiResult.Success(service.getWorkouts().workouts))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.toUserMessage()))
        }
    }

}
