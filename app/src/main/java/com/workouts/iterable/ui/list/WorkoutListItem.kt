package com.workouts.iterable.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.workouts.iterable.network.model.Workout

@Composable
fun WorkoutListItem(workout: Workout, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(text = workout.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "${workout.category} • ${workout.duration} mins")
                Text(text = workout.difficulty, color = Color.Gray)
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(workout.imageLink)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                contentDescription = "workout_thumb",
                modifier = Modifier
                    .size(150.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
