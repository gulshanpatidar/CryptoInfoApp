package com.example.cryptoinfoapp.data.util

//this class is used to return the result when doing an api call
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    //when result is successful, then directly return the data
    class Success<T>(data: T): Resource<T>(data)
    //if there is an error then return the message along with nullable data
    class Error<T>(message: String,data: T? = null): Resource<T>(message = message, data = data)
}