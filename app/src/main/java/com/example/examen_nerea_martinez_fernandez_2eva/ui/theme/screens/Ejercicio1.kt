package com.example.examen_nerea_martinez_fernandez_2eva.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examen_nerea_martinez_fernandez_2eva.R
//ESTE SI
@Preview
@Composable
fun ExamenPruebaConEstado(){
    var numCont : String by remember { mutableStateOf("") }
    var numContInt by remember { mutableStateOf(0) }
    var visible by remember { mutableStateOf(false) }
    val onConvert = {
        numContInt = numCont.toInt()
        visible = !visible
    }
    PantallaPrueba(numString=numCont, onContChange= {numCont = it}, numContInt = numContInt,
        onIncrement = {numContInt++}, onDecrement = { numContInt-- },
        onConvert = onConvert, visible = visible, onChangeVis = {visible = !visible})
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrueba( numString: String, onContChange:(String)->Unit, numContInt : Int,
                    onIncrement : () ->Unit, onDecrement: () -> Unit, onConvert: ()->Unit, visible : Boolean,
                    onChangeVis : () -> Unit){

    val elementos : List<String> = List(numContInt){"Item ${it}"}

    Scaffold (
        topBar = { TopAppBar (
            title = { Text(text = stringResource(R.string.app_name)) },
            actions = {
                if(visible){
                    IconButton(onClick =  onChangeVis) {
                        Icon(Icons.Default.Refresh,contentDescription = null)
                    }
                    IconButton(onClick = onIncrement) {
                        Icon(Icons.Default.Add,contentDescription = null)
                    }
                    IconButton(onClick =onDecrement) {
                        Icon(Icons.Default.Delete,contentDescription = null)
                    }
                }

            })
        }
    ){
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            if(!visible){
                OutlinedTextField(value = numString,
                    onValueChange = onContChange,
                    label = { Text(text = stringResource(R.string.num_contadores)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(onClick = onConvert ) {
                    Text(text = stringResource(R.string.ver))
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            if(visible){
                LazyColumn{
                    items(elementos){
                            el -> ElementoRow(nombreElemento = el)
                    }
                }
            }

        }
    }
}
@Composable
fun ElementoRow(nombreElemento : String, modifier : Modifier = Modifier){
    var cont by remember { mutableStateOf(0)}

    Column (verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text=nombreElemento)
            IconButton(onClick = { cont++ }) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = null)
            }
            IconButton(
                onClick = {cont--},
                enabled = cont>0) {
                Icon(imageVector = Icons.Default.Delete,
                    contentDescription = null)
            }
            Text(text = "Cont:${cont}")
        }
    }

}