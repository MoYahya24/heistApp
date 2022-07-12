package com.example.heistux

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.heistux.ui.accounts.collectionView.HasAccount
import com.example.heistux.ui.accounts.collectionView.NoAccount
import com.example.heistux.ui.theme.HeistUXTheme
import com.example.heistux.ui.transactions.collectionView.TransactionsCollectionView
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.transactions.Transaction
import java.math.BigDecimal
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeistUXTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //val party = Generate()
                    val x : OffsetDateTime = OffsetDateTime.now()
                    val y = OffsetDateTime.now()
                    val z = OffsetDateTime.now()
                    //val transactions = listOf<Transaction>(Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))),Transaction(booked = x, info = "L7aj", amount = Amount(value = BigDecimal.valueOf(50.00))), Transaction(booked = y, info = "Proxi", amount = Amount(value = BigDecimal.valueOf(21.58))), Transaction(booked = z, info = "GH", amount = Amount(value = BigDecimal.valueOf(40.00))))
                    //TransactionsCollectionView(transactions = transactions)

                    //HasAccount(party = Generate())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeistUXTheme {
        //NoAccount("yahya")
    }
}