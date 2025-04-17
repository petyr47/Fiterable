package com.workouts.iterable.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.toUserMessage(): String {
    return when (this) {
        is HttpException -> when (this.code()) {
            400 -> "Bad request."
            401 -> "Unauthorized. Please log in again."
            403 -> "You don't have permission to access this."
            404 -> "Not found."
            500 -> "Server error. Please try again later."
            else -> "Unexpected error: ${this.code()}."
        }
        is UnknownHostException -> "No internet connection."
        is SocketTimeoutException -> "Connection timed out."
        is IOException -> "Network error. Please check your connection."
        else -> "Something went wrong. Please try again."
    }
}