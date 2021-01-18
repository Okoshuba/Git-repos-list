package com.example.gitrepositories.network

import com.example.gitrepositories.Repository.Owner
import com.example.gitrepositories.Repository.Users
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    interface UsersAPI {
        @GET("repositories")
        fun getUsers(): Call<List<Users>>
    }
}