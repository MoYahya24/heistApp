package com.example.heistux.ui.transactions.collectionView

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heistux.ui.navigation.NavDrawer
import io.heist.store.model.core.transactions.Transaction

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionsCollectionView(transactions: List<Transaction>) {

    NavDrawer() {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF000000))
        ) {

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
                        .height(40.dp))

                    Column(Modifier.verticalScroll(rememberScrollState())) {
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
                                        text = "${transaction.booked!!.dayOfMonth}/${transaction.booked!!.monthValue}/${transaction.booked!!.year} at ${transaction.booked!!.hour}:${transaction.booked!!.minute}",
                                        color = Color(0xFFFFFFFF),
                                        fontSize = MaterialTheme.typography.body1.fontSize,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(top = 10.dp, start= 25.dp)
                                    )
                                }
                                Text(
                                    text = "${transaction.info}",
                                    color = Color(0xFFFFFFFF),
                                    fontSize = MaterialTheme.typography.h6.fontSize,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding( end = 25.dp)
                                )

                            }


                        }
                    }

                }


            }

        }
    }



}
