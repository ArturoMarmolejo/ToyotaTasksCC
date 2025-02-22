package com.arturomarmolejo.toyotataskscc.core

/**
 * [UIState] sealed class for handling different scenarios according
 * to the stream of data that is received from the repository in the data layer to the presentation layer
 * such as loading, success, and error.
 */
sealed class UIState<out T> {
    data object LOADING: UIState<Nothing>()
    data class SUCCESS<T>(val response: T): UIState<T>()
    data class ERROR(val message: String): UIState<Nothing>()
}