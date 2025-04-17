package com.workouts.iterable.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workouts.iterable.network.model.Workout
import com.workouts.iterable.repositories.WorkoutRepository
import com.workouts.iterable.utils.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(val repository: WorkoutRepository): ViewModel() {


    private val _workoutsState = MutableStateFlow<ApiResult<List<Workout>>>(ApiResult.Loading)
    val workoutsState: StateFlow<ApiResult<List<Workout>>> = _workoutsState

    private val _selectedWorkoutFlow = MutableStateFlow<Workout?>(null)
    val selectedWorkout: StateFlow<Workout?> = _selectedWorkoutFlow


    init {
        fetchWorkouts()
    }

    private fun fetchWorkouts() {
        viewModelScope.launch {
            _workoutsState.value = ApiResult.Loading
            repository.getWorkouts().collect{
                _workoutsState.value = it
            }
        }
    }

    fun selectWorkout(workout: Workout) {
        _selectedWorkoutFlow.value = workout
    }

}