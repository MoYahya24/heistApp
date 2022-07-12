package com.example.heistux.ui.homeScreen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.ButtonSize
import com.example.heist_cx_drd.ui.components.HeistButton
import com.example.heist_cx_drd.ui.theme.White
import com.example.heistux.ui.navigation.Screen
import com.google.gson.Gson

@Composable
fun Home(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    ) {

        Text(
            text = "HEIST.",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start=28.dp, top = 150.dp)
        )

        Card( modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize()) {

                Text(
                    text = "Heist is an app that takes monitoring your bank accounts to a whole new level, with a variety of functionalities that help you manage all of your bank accounts and transactions all in one place. ",
                    color = Color(0xFFFFFFFF),
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.padding( start= 25.dp, top = 60.dp, end = 25.dp)
                )

                HeistButton(action = {navController.navigate(Screen.Login.route)}, size = ButtonSize.MEDIUM, text = "LOG-IN", modifier = Modifier
                    .padding(start = 25.dp, top = 60.dp))

                HeistButton(action = {navController.navigate(Screen.Create1.route)}, size = ButtonSize.MEDIUM, text = "CREATE YOUR ACCOUNT", modifier = Modifier
                    .padding(start = 25.dp, top = 30.dp)
                    .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape))

            }


        }

    }


}