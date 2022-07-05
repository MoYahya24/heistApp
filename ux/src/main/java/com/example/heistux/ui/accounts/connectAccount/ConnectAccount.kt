package com.example.heistux.ui.accounts.connectAccount

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.components.ButtonSize
import com.example.heist_cx_drd.ui.components.ComboBox
import com.example.heist_cx_drd.ui.components.HeistButton
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.heist.store.model.core.parties.Party

@Destination
@Composable
fun ConnectAccount(navigator: DestinationsNavigator, party : Party) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Connect Your Account?",
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
                    HeistButton(action = {}, size = ButtonSize.MEDIUM, text ="CANCEL" , modifier = Modifier
                        .padding(start=10.dp, bottom = 30.dp, top = 30.dp, end = 20.dp), hasBorder = false)


                    HeistButton(action = { /*TODO*/ }, size = ButtonSize.MEDIUM, text ="CHOOSE YOUR BANK" , modifier = Modifier
                        .padding(bottom = 30.dp, top = 30.dp, end = 20.dp))

                }


            }
        }
    }
}