package com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
//ESTE SI
class ExamenViewModel : ViewModel () {
    var numCont : String by mutableStateOf("")
    fun setNum(value: String) {
        numCont = value
    }
    var numContInt by  mutableStateOf(0)
    var visible by mutableStateOf(false)
    val onConvert = {
        numContInt = numCont.toInt()
        visible = !visible
    }
    val onChangeVis = {
        visible = !visible
    }
    fun suma() {
        numContInt++
    }
    fun resta() {
        numContInt--
    }
}