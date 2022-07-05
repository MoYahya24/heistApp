package com.example.heistux.ui.accounts.openAccount


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.*
import com.example.heist_cx_drd.ui.theme.White
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.heist.store.model.core.parties.Party

@Destination
@Composable
fun OpenAcc1(party: Party, navigator: DestinationsNavigator){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Where would you like to open an account?",
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
                    Text(
                        text = "Bank name",
                        color = Color(0xFFFFFFFF),
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                    )
                    val banks= listOf<String>("CommonWealth","WestPac","ANZ","NAB")
                    ComboBox(list = banks, text = "-select bank-", boxmodifier = Modifier.padding(horizontal = 20.dp))
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                ) {
                    HeistButton(action = {  }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)


                    HeistButton(action = { }, size = ButtonSize.MEDIUM, text ="GO TO PERSONAL DETAILS" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))

                }


            }
        }
    }
}

@Destination
@Composable
fun OpenAcc2(party: Party, navigator: DestinationsNavigator) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Confirm your personal details to use for your new account",
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

                    var name by remember { mutableStateOf("") }
                    HeistTextField(fieldLabel = "Full name",
                        icon = Icons.Outlined.Person,
                        fieldType = KeyboardType.Text,
                        value = name,
                        onvaluechange = {newName : String ->
                            name = newName
                            if (newName.length <= 20) name = newName
                        },
                        modifier = Modifier.padding(start=20.dp, top=20.dp))

                    var address by remember { mutableStateOf("") }
                    HeistTextField(fieldLabel = "Full name",
                        icon = Icons.Outlined.Home,
                        fieldType = KeyboardType.Text,
                        value = address,
                        onvaluechange = {newAddress : String ->
                            name = newAddress
                        },
                        modifier = Modifier.padding(start=20.dp, top=20.dp))

                    var phone by remember { mutableStateOf("") }
                    HeistTextField(fieldLabel = "Full name",
                        icon = Icons.Outlined.Phone,
                        fieldType = KeyboardType.Phone,
                        value = phone,
                        onvaluechange = {newPhone : String ->
                            name = newPhone
                        },
                        modifier = Modifier.padding(start=20.dp, top=20.dp))

                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    HeistButton(action = {  }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)

                    HeistButton(action = {  }, size = ButtonSize.MEDIUM, text ="GO TO ACCOUNT TYPE" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }
        }
    }
}

@Destination
@Composable
fun OpenAcc3(party: Party, navigator: DestinationsNavigator) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Choose the kind of account you would like to open",
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
                    val list= listOf<String>("Checkings","Savings")
                    GroupedCheckbox(list = list, Size.LARGE, modifier = Modifier.padding(40.dp))

                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                ) {
                    HeistButton(action = { }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)

                    HeistButton(action = {  }, size = ButtonSize.MEDIUM, text ="CONFIRM" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }
        }
    }
}

@Destination
@Composable
fun OpenAcc4(party: Party, navigator: DestinationsNavigator) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Account Opened",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, top = 132.dp)
        )
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Thank You!",
                        color = Color(0xFFFFFFFF),
                        fontSize = MaterialTheme.typography.h4.fontSize,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                    )
                    Icon(imageVector = Icons.Outlined.CheckCircle,  contentDescription = "", tint = White, modifier = Modifier.padding(top= 60.dp, bottom = 200.dp).scale(5F))
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth().wrapContentHeight()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                ) {

                    HeistButton(action = {  }, size = ButtonSize.MEDIUM, text ="GO TO DASHBOARD" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }
        }
    }
}