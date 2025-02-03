package com.nicolaischirmer.proyectoapirickymorty.api

data class Result(
    val info: Info,
    val results: List<Characters>
)