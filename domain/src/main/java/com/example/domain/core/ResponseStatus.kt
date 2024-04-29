package com.example.domain.core

sealed class ResponseStatus<out T: Any> {
    data class Success<out T: Any>(val result: T) : ResponseStatus<T>()

    data class Error(val error: Throwable) : ResponseStatus<Nothing>()

    data object Loading : ResponseStatus<Nothing>()

}