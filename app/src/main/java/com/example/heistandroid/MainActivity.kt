package com.example.heistandroid

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.heistandroid.ui.theme.HeistAndroidTheme
import com.example.heistux.ui.accounts.collectionView.HasAccount
import com.example.heistux.ui.homeScreen.home.Home
import com.example.heistux.ui.homeScreen.login.Login
import com.example.heistux.ui.navigation.Navigation
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.institutes.Institute
import io.heist.store.model.core.parties.Party
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeistAndroidTheme {

            Navigation(party = Generate())
               
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
    HeistAndroidTheme {
        Greeting("Android")
    }
}


fun Generate() : Party {
    val acc1 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )
    val acc2 = Account(type = "Personal", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(124))), institute = Institute(ref = "CIH") )
    val acc3 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )
    val acc4 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )
    val acc5 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )
    val acc6 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )
    val acc7 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )
    val acc8 = Account(type = "Business", balance = Balance(type = "ClosingAvailable", amount = Amount(value = BigDecimal.valueOf(500))), institute = Institute(ref = "BMCE") )

    val party = Party( number = "0651151490",name = "Yahya", legalName = "Mohamed Yahya Bouaalam", /*accounts = mutableListOf(acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8)*/)
    return party
}