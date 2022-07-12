package com.example.heistux.ui.homeScreen.create

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.*
import com.example.heistux.ui.navigation.Screen
import com.google.gson.Gson
import io.heist.store.model.core.parties.Party

@Composable
fun Create2(password: String, username: String, navController: NavController) {
    var name = FieldText()
    var legalname = FieldText()
    var email = FieldText()
    var phone = FieldText()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        val context = LocalContext.current
        Text(
            text = "Personal Details",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, top = 132.dp)
        )
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.wrapContentSize()) {

                    HeistTextField(fieldLabel = "Preffered Name",
                        icon = Icons.Outlined.Face,
                        fieldType = KeyboardType.Text,
                        modifier = Modifier.padding(start=20.dp, top=20.dp),
                        text = name
                    )

                    HeistTextField(fieldLabel = "Full Name",
                        icon = Icons.Outlined.Person,
                        fieldType = KeyboardType.Text,
                        modifier = Modifier.padding(start=20.dp, top=20.dp),
                        text = legalname
                    )


                    HeistTextField(fieldLabel = "E-mail Address",
                        icon = Icons.Outlined.Email,
                        fieldType = KeyboardType.Email,
                        modifier = Modifier.padding(start=20.dp, top=20.dp),
                        text = email
                    )

                    HeistTextField(fieldLabel = "Phone Number",
                        icon = Icons.Outlined.Phone,
                        fieldType = KeyboardType.Phone,
                        modifier = Modifier.padding(start=20.dp, top=20.dp),
                        text = phone
                    )

                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    HeistButton(action = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                    }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)

                    HeistButton(action = {

                        if(phone.text!=null && name.text!=null && email.text!=null && legalname.text!=null) {
                            val p = Party(username = username, password = password, name=name.text, legalName = legalname.text, email = email.text, phone= phone.text)
                            val partyJson = Gson().toJson(p) as String
                            navController.navigate(Screen.Created.route+"/${partyJson}")
                        }
                        else {
                            Toast.makeText(context, "Invalid input!", Toast.LENGTH_SHORT).show()
                        }
                        }, size = ButtonSize.MEDIUM, text ="CREATE YOUR ACCOUNT" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }
        }
    }
}

@Composable
fun Create1(navController: NavController) {
    var user = FieldText()
    var password = FieldText()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    ) {

        //Divider(color = White, thickness = 1.dp, modifier = Modifier.width(300.dp))
        val context = LocalContext.current
        Text(
            text = "CREDENTIALS",
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

                    HeistTextField(fieldLabel = "Username",
                        icon = Icons.Outlined.Person,
                        fieldType = KeyboardType.Text,
                        modifier = Modifier.padding(start=20.dp, top= 80.dp),
                        text = user
                    )


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

                    HeistButton(action = {
                        if(user.text!=null && password.text!=null) {
                            navController.navigate(Screen.Create2.route+"/${user.text}"+"/${password.text}")
                        }
                        else {
                            Toast.makeText(context, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                        }
                                         }, size = ButtonSize.MEDIUM, text ="CONTINUE" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }




        }

    }
}


@Composable
fun Created(party : Party, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    ) {

        Text(
            text = "Account Created!",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(top = 150.dp)
                .align(Alignment.CenterHorizontally),
        )

        Card( modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {

                Column(Modifier.wrapContentHeight()) {

                    Text(
                        text = "Welcome to Heist, ${party.name}",
                        color = Color(0xFFFFFFFF),
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 70.dp)
                    )

                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                ) {
                    val partyJson = Gson().toJson(party) as String
                    HeistButton(action = {navController.navigate(Screen.AccCollectionView.route+"/${partyJson}")}, size = ButtonSize.MEDIUM, text ="GO TO DASHBOARD" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }

            }


        }

    }
}