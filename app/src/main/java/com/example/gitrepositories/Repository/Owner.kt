package com.example.gitrepositories.Repository

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Owner (
    @SerializedName("login")
    @Expose
    val login: String
)
