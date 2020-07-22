package com.fazal.mviarchitecturedaggerhilt.model

/**
 * Blog Data Class - Domain Layer
 */
data class Blog (
    val id: Int,
    val title: String,
    val body: String,
    val image: String,
    val category: String
)

