package com.workouts.iterable.ui.navigation

import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.workouts.iterable.ui.WorkoutViewModel
import com.workouts.iterable.ui.detail.WorkoutDetailScreen
import com.workouts.iterable.ui.list.WorkoutListScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WorkoutAppNavHost(
    navController: NavHostController,
    viewModel: WorkoutViewModel,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            WorkoutListScreen(
                viewModel = viewModel,
                onWorkoutClick = { workoutId ->
                    viewModel.selectWorkout(workoutId)
                navController.navigate("detail/${workoutId.id}")
            })
        }

        composable(
            route = "detail/{id}",
            enterTransition = { fadeIn(animationSpec = tween(1000)) },
            exitTransition = { fadeOut(animationSpec = tween(500)) }
        ) {
            WorkoutDetailScreen(viewModel, onBack = {
                navController.popBackStack()
            })
        }


    }
}

