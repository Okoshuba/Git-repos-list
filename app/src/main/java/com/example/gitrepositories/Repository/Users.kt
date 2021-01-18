package com.example.gitrepositories.Repository

data class Users (
    val id: String,
    val name: String,
    val description: String,
    val owner: Owner,
    val html_url: String
)