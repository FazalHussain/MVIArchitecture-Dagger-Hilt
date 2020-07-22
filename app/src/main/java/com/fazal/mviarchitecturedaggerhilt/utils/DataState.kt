package com.fazal.mviarchitecturedaggerhilt.utils

/**
 * Data State Sealed Class for handling success, error, and loading data states
 */
sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}