package com.example.heistux.ui.transactions.collectionView

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heist_cx_drd.ui.theme.White
import com.example.heistux.ui.navigation.NavDrawer
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.parties.Party
import io.heist.store.model.core.transactions.Transaction

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionsCollectionView(account: Account?= null, party: Party, navController: NavController) {

    lateinit var transactions : MutableList<Transaction>

    if(account==null) {
        transactions = mutableListOf<Transaction>()
        party.accounts?.forEach { it->
            if( it.transactions != null ) {
                transactions.addAll(it.transactions!!)
            }
        }
    }

    else {
        transactions = mutableListOf<Transaction>()

        if( account.transactions != null ) {
            transactions.addAll(account.transactions!!)
        }

    }
    if(!transactions.isNullOrEmpty()) {
        transactions.sortedBy {it.booked}
    }


    NavDrawer(navController = navController, party = party) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF000000))
        ) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Divider(color = White, thickness = 1.dp, modifier = Modifier.width(300.dp))
            }

            Text(
                text = "Transactions",
                color = Color(0xFFFFFFFF),
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 120.dp, start= 20.dp)
            )

            Card( modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp), backgroundColor = Color(0xFF101010)

            ) {

                Column(
                    Modifier
                        .fillMaxSize()
                    ) {

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp))

                    if(account!=null) {
                        Text(
                            text = "${account.accType.value} Account at ${account.institute?.ref}",
                            color = Color(0xFFFFFFFF),
                            fontSize = MaterialTheme.typography.h5.fontSize,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start= 25.dp)
                        )
                        Divider(color = White, thickness = 1.dp, modifier = Modifier
                            .width(250.dp)
                            .padding(top = 20.dp, start = 30.dp))
                    }


                    Column(Modifier.verticalScroll(rememberScrollState())) {
                        if(transactions.isNullOrEmpty()) {
                            NoTransactions()
                        }

                        else {
                            HasTransactions(transactions = transactions)
                        }
                    }

                }


            }

        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HasTransactions(transactions: List<Transaction>) {
    transactions.forEach { transaction ->

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Text(
                    text = "${transaction.amount!!.value}",
                    color = Color(0xFFFFFFFF),
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding( start= 25.dp)
                )
                Text(
                    text = "${transaction.booked}",
                    color = Color(0xFFFFFFFF),
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp, start= 25.dp)
                )
            }
            Text(
                text = "${transaction.to?.name}",
                color = Color(0xFFFFFFFF),
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding( end = 25.dp)
            )

        }


    }
}

@Composable
fun NoTransactions() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Uh-Oh...",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 80.dp, start= 20.dp)
        )
        Text(
            text = "There are no transactions to display :(",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 30.dp, start= 20.dp)
        )
    }

}
