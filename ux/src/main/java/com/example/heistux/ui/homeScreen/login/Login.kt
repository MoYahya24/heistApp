package com.example.heistux.ui.homeScreen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.*
import com.example.heist_cx_drd.ui.theme.White
import com.example.heistux.ui.navigation.Screen
import com.google.gson.Gson

@Composable
fun Login(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    ) {

        //Divider(color = White, thickness = 1.dp, modifier = Modifier.width(300.dp))

        Text(
            text = "LOG-IN",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start=28.dp, top = 150.dp)
        )

        Card( modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.fillMaxWidth()) {
                    var user = FieldText()
                    HeistTextField(fieldLabel = "Username",
                        icon = Icons.Outlined.Person,
                        fieldType = KeyboardType.Text,
                        modifier = Modifier.padding(start=20.dp, top= 80.dp),
                        text = user
                    )

                    var password = FieldText()
                    PasswordTextField(fieldLabel = "Password",
                        icon = Icons.Outlined.Lock,
                        fieldType = KeyboardType.Password,
                        modifier = Modifier.padding(start=20.dp, top=30.dp),
                        text = password
                    )
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    HeistButton(action = {navController.popBackStack()}, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)

                    HeistButton(action = {}, size = ButtonSize.MEDIUM, text ="CONFIRM & GO TO DASHBOARD" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }




        }

    }
}
