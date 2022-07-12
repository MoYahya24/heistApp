package com.example.heistux.ui.accounts.openAccount


import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.*
import com.example.heist_cx_drd.ui.theme.White
import com.example.heistux.ui.navigation.Screen
import com.google.gson.Gson
import io.heist.store.model.core.parties.Party
import io.heist.store.model.core.accounts.*
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.institutes.Institute
import java.math.BigDecimal

@Composable
fun OpenAcc1(navController: NavController, party: Party){

    var comboText = ComboBoxText()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        val context = LocalContext.current
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
                    ComboBox(list = banks, boxmodifier = Modifier.padding(horizontal = 20.dp), comboBoxText = comboText)
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                ) {
                    HeistButton(action = { navController.popBackStack() }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)


                    HeistButton(action = {
                        if(comboText.text=="") {
                            Toast.makeText(context, "Please Choose A Valid Bank", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            val partyJson = Gson().toJson(party) as String
                            val bank= comboText.text
                            navController.navigate(Screen.OpenAccount2.route+"/${partyJson}"+"/${bank}")
                        }

                    }, size = ButtonSize.MEDIUM, text ="GO TO PERSONAL DETAILS" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))

                }


            }
        }
    }
}


@Composable
fun OpenAcc2(navController: NavController, party: Party, bank: String) {
    var name = FieldText()
    var address = FieldText()
    var phone = FieldText()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        val context = LocalContext.current
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

                    HeistTextField(fieldLabel = "Full name",
                        icon = Icons.Outlined.Person,
                        fieldType = KeyboardType.Text,
                        modifier = Modifier.padding(start=20.dp, top=20.dp),
                        text = name
                    )

                    HeistTextField(fieldLabel = "Email Address",
                        icon = Icons.Outlined.Email,
                        fieldType = KeyboardType.Text,
                        modifier = Modifier.padding(start=20.dp, top=20.dp),
                        text = address
                    )


                    HeistTextField(fieldLabel = "Full name",
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
                        val partyJson = Gson().toJson(party) as String
                        navController.navigate(Screen.AccCollectionView.route+"/${partyJson}") {
                            popUpTo(Screen.AccCollectionView.route+"/${partyJson}") {
                                inclusive = true
                            }
                        }

                        }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)

                    HeistButton(action = {
                        if(phone.text.equals(party.phone) && name.text.equals(party.legalName) && address.text.equals(party.email)) {
                            val partyJson = Gson().toJson(party) as String
                            navController.navigate(Screen.OpenAccount3.route+"/${partyJson}"+"/${bank}")
                        }
                        else {
                            Toast.makeText(context, "Make sure the Information matches your account's details!", Toast.LENGTH_SHORT).show()
                        }
                    }, size = ButtonSize.MEDIUM, text ="GO TO ACCOUNT TYPE" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }
        }
    }
}

@Composable
fun OpenAcc3(navController: NavController, party: Party, bank: String) {

    var checkedOption = CheckedOption("")

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        val context = LocalContext.current
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
                    val list= listOf<String>("Business","Personal")
                    GroupedCheckbox(list = list, Size.LARGE, modifier = Modifier.padding(40.dp), checkedOption = checkedOption)

                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                ) {
                    HeistButton(action = {
                        val partyJson = Gson().toJson(party) as String
                        navController.navigate(Screen.AccCollectionView.route+"/${partyJson}") {
                            popUpTo(Screen.AccCollectionView.route+"/${partyJson}") {
                                inclusive = true
                            }
                        }
                    }, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)

                    HeistButton(action = {

                        if(checkedOption.text=="") {
                            Toast.makeText(context, "Please Choose Your New Account Type", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            val partyJson = Gson().toJson(party) as String
                            val type = checkedOption.text
                            navController.navigate(Screen.OpenAccount4.route+"/${partyJson}"+"/${bank}"+"/${type}")
                        }

                    }, size = ButtonSize.MEDIUM, text ="CONFIRM" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }


            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OpenAcc4(navController: NavController, party: Party, bank: String, type: String) {

    val acc = Account(type= type, institute = Institute(ref = bank), balance = Balance(amount = Amount(value = BigDecimal.valueOf(0))))
    party.accounts!!.add(acc)

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
                    Icon(imageVector = Icons.Outlined.CheckCircle,  contentDescription = "", tint = White, modifier = Modifier
                        .padding(top = 60.dp, bottom = 200.dp)
                        .scale(5F))
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    .wrapContentHeight()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                ) {

                    HeistButton(action = {
                        val partyJson = Gson().toJson(party) as String
                        navController.navigate(Screen.AccCollectionView.route+"/${partyJson}")
                    }, size = ButtonSize.MEDIUM, text ="GO TO DASHBOARD" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))
                }

            }
        }
    }
}