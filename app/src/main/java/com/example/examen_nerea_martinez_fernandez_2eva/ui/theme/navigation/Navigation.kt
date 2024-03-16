package com.example.ejercicioscomposeentrega.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens.ExamenPruebaConEstado
import com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens.ExamenViewModel
import com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens.Menu
import com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens.PantallaPrueba2

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.Menu.route){
        composable(route=Screens.Menu.route){ Menu(navController = navController) }
        composable(route= Screens.Ejercicio1.route){
            ExamenPruebaConEstado() //Nombre de la funcion a ejecutar
        }
        composable(route= Screens.Ejercicio2.route){
           PantallaPrueba2(viewModel = ExamenViewModel())//Nombre de la funcion a ejecutar
        }
    }

}