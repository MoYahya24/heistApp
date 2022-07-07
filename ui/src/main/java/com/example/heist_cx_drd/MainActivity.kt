package com.example.heist_cx_drd

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heist_cx_drd.ui.components.*
import com.example.heist_cx_drd.ui.theme.HeistcxdrdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeistcxdrdTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(name: String) {
    var x : MutableState<Int> = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))) {
        //NavDrawer()
        Text(text = "${x.value}", color = Color(0xFFFFFFFF))
        //ComboBox(listOf<String>("CommonWealth","WestPac","ANZ","NAB"), "Choose A Bank")
        HeistButton(action = { x.value += 1 }, size = ButtonSize.MEDIUM , name, modifier = Modifier.padding(30.dp))
       // HeistTextField(fieldLabel = "Email", icon = Icons.Outlined.Email, fieldType = KeyboardType.Email)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeistcxdrdTheme {
        //eywa()
        //Greeting(name = "SUBMIT")
    }
}