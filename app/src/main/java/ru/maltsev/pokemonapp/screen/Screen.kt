package ru.maltsev.pokemonapp.screen

sealed class Screen(val route: String) {
    object Intro: Screen(route = "intro_screen")
    object Main: Screen(route = "main_screen")
}