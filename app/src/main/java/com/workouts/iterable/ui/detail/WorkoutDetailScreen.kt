package com.workouts.iterable.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.workouts.iterable.R
import com.workouts.iterable.ui.WorkoutViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutDetailScreen(
    viewModel: WorkoutViewModel,
    onBack: () -> Unit
) {
    val workout = viewModel.selectedWorkout.collectAsState().value!!

    Box{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(workout.imageLink)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                contentDescription = "workout_image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(workout.imageHeight.div(2).dp),
                contentScale = ContentScale.Crop
            )

            Column(Modifier.padding(16.dp)) {
                Text(workout.title, style = MaterialTheme.typography.headlineSmall)
                Text("${workout.category} • ${workout.duration} min", color = Color.Gray)
                Spacer(Modifier.height(8.dp))
                Text("Difficulty: ${workout.difficulty}")
                Text("Instructor: ${workout.instructor}")
                Spacer(Modifier.height(12.dp))
                Text(workout.description)
            }
        }
        Icon(
            painter = painterResource(R.drawable.arrow_back),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .size(40.dp)
                .clickable {
                    onBack()
                },
        )
    }
}

