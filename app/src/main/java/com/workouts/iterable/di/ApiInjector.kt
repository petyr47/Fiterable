package com.workouts.iterable.di

import com.workouts.iterable.network.RetrofitClient
import com.workouts.iterable.repositories.WorkoutRepository
import com.workouts.iterable.ui.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val network = module {
    single { RetrofitClient.makeApiService() }
}

private val viewModels = module {
    viewModel { WorkoutViewModel(get()) }
}


private val repositories = module {
    single { WorkoutRepository(get()) }
}

private val useCases = module {

}

val appModules = listOf(network, viewModels, repositories, useCases)
