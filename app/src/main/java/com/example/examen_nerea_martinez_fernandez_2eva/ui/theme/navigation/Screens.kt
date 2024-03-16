package com.example.ejercicioscomposeentrega.ui.theme.navigation

sealed class Screens(val route: String){ //defino las pantallas a las que navegar
    object Menu: Screens("initial_screen")
    object Ejercicio1 : Screens ("ejExamen")
    object Ejercicio2 : Screens ("ejExamen2")
}
