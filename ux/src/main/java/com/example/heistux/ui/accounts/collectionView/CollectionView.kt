package com.example.heistux.ui.accounts.collectionView


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.ButtonSize
import com.example.heist_cx_drd.ui.components.HeistButton
import com.example.heistux.ui.navigation.NavDrawer
import com.example.heistux.ui.navigation.Screen
import com.example.heistux.ui.theme.Black
import com.example.heistux.ui.theme.White
import com.google.gson.Gson
import io.heist.store.model.core.parties.Party
import java.math.BigDecimal

@Composable
fun AccountsCollectionView(navController: NavController, party : Party ) {

    if(party.accounts.isNullOrEmpty()) {
        NoAccount(party = party, navController)
    }

    else {
        HasAccount(party = party, navController )
    }
    
}

@Composable
fun NoAccount(party : Party, navController: NavController) {

    NavDrawer(party = party, navController = navController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF000000))
        ) {

            Divider(color = com.example.heist_cx_drd.ui.theme.White, thickness = 1.dp, modifier = Modifier.width(300.dp))

            Text(
                text = "Welcome, " + party.name,
                color = Color(0xFFFFFFFF),
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 85.dp, start = 20.dp, end= 25.dp)
            )

            Card( modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp), backgroundColor = Color(0xFF101010)
            ) {
                Column(Modifier.fillMaxSize()) {
                    Text(
                        text = "How It Works",
                        color = Color(0xFFFFFFFF),
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(top = 60.dp, start= 25.dp)
                    )

                    Text(
                        text = "To get started, you need to have an account. You can use an account you already have with a bank we partner with, or you can open an new account.",
                        color = Color(0xFFFFFFFF),
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier.padding( start= 25.dp, top = 30.dp)
                    )

                    HeistButton(action = {
                        val partyJson = Gson().toJson(party) as String
                        navController.navigate(Screen.ConnectAccount.route+"/${partyJson}")

                    }, size = ButtonSize.MEDIUM, text = "CONNECT AN ACCOUNT", modifier = Modifier
                        .padding(start = 25.dp, top = 30.dp))

                    HeistButton(action = {
                        val partyJson = Gson().toJson(party) as String
                        navController.navigate(Screen.OpenAccount1.route+"/${partyJson}")

                    }, size = ButtonSize.MEDIUM, text = "OPEN AN ACCOUNT", modifier = Modifier
                        .padding(start = 25.dp, top = 30.dp)
                        .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape))

                }


            }

        }
    }

}
@Composable
fun HasAccount(party : Party, navController: NavController) {

    val partyJson = Gson().toJson(party) as String
    var totalBalance : BigDecimal = BigDecimal.valueOf(0)

   for(account in party.accounts!!) {
       totalBalance += account.balance!!.amount!!.value!!
  }

    NavDrawer(navController = navController, party = party) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF000000))
        ) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Divider(color = com.example.heist_cx_drd.ui.theme.White, thickness = 1.dp, modifier = Modifier.width(300.dp))
            }

            Text(
                text = "Accounts",
                color = Color(0xFFFFFFFF),
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 30.dp, start= 20.dp, bottom=5.dp)
            )

            Divider(color = White, thickness = 1.dp, modifier = Modifier
                .width(150.dp)
                .padding(start = 20.dp))

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier
                .background(Color(0xFF000000))
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 30.dp)
            ) {

                HeistButton(action = {

                    navController.navigate(Screen.OpenAccount1.route+"/${partyJson}")

                }, size = ButtonSize.MEDIUM, text ="OPEN AN ACCOUNT" , modifier = Modifier
                    .padding(start=20.dp)
                )

                HeistButton(action = {

                    navController.navigate(Screen.ConnectAccount.route+"/${partyJson}")

                }, size = ButtonSize.MEDIUM, text ="CONNECT ACCOUNT" , modifier = Modifier
                    .padding(top = 20.dp, bottom = 30.dp, start = 20.dp)
                        )

            }


            Card( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp), backgroundColor = Color(0xFF101010)
            ) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 5.dp, bottom = 20.dp)) {
                        Text(
                            text = "Total",
                            color = Color(0xFFFFFFFF),
                            fontSize = MaterialTheme.typography.h4.fontSize,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 25.dp, start = 25.dp)
                        )
                        Text(
                            text = "${totalBalance}",
                            color = Color(0xFFFFFFFF),
                            fontSize = MaterialTheme.typography.h4.fontSize,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 25.dp, end = 25.dp)
                        )
                    }
                    Divider(color = White, thickness = 1.dp, modifier = Modifier.width(250.dp))

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())) {

                        party.accounts!!.forEach { account ->
                            val acc = Gson().toJson(account) as String
                            Row(
                                Modifier
                                    .clickable {
                                        navController.navigate(Screen.TransactionCollectionView.route + "/${acc}" + "/${partyJson}")
                                    }
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                Column() {
                                    Text(
                                        text = "${account.accType}",
                                        color = Color(0xFFFFFFFF),
                                        fontSize = MaterialTheme.typography.h6.fontSize,
                                        fontWeight = FontWeight.Light,
                                        modifier = Modifier.padding(top = 20.dp, start= 25.dp)
                                    )
                                    Text(
                                        text = "${account.institute!!.ref}",
                                        color = Color(0xFFFFFFFF),
                                        fontSize = MaterialTheme.typography.body1.fontSize,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(top = 10.dp, start= 25.dp)
                                    )
                                }
                                Text(
                                    text = "${account.balance!!.amount!!.value}",
                                    color = Color(0xFFFFFFFF),
                                    fontSize = MaterialTheme.typography.h6.fontSize,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 20.dp, end = 25.dp)
                                )

                            }


                        }
                        
                    }

                }

            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        //HasAccount(party = )
}