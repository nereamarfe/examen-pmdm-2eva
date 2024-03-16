package com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.ejercicioscomposeentrega.ui.theme.navigation.Screens

@Composable
fun Menu(navController: NavController){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {navController.navigate(route= Screens.Ejercicio1.route)}) {
            Text(text = "Ejercicio examen")
        }
        Button(onClick = {navController.navigate(route= Screens.Ejercicio2.route)}) {
            Text(text = "Ejercicio examen VM")
        }

    }
}