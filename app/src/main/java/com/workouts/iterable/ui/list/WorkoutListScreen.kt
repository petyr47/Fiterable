package com.workouts.iterable.ui.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.workouts.iterable.network.model.Workout
import com.workouts.iterable.ui.WorkoutViewModel
import com.workouts.iterable.utils.ApiResult

@Composable
fun WorkoutListScreen(
    viewModel: WorkoutViewModel,
    onWorkoutClick: (Workout) -> Unit
) {
    val workoutsState = viewModel.workoutsState.collectAsState().value

    when (workoutsState) {
        is ApiResult.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ApiResult.Success -> {
            LazyColumn {
                items(workoutsState.data) { workout ->
                    WorkoutListItem(workout = workout, onClick = { onWorkoutClick(workout) })
                }
            }
        }
        is ApiResult.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = workoutsState.message, color = Color.Red)
            }
        }
    }
}
