package br.com.katharinefernandes.ludoon.ui.models

data class Feed (
    val userNickname: String,
    val localName: String,
    val userAvatar: String,
    val imageUrl: String,
    val description: String,
    val postedAgo: String
)