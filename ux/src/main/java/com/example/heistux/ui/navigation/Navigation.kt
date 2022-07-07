package com.example.heistux.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.heistux.ui.accounts.collectionView.AccountsCollectionView
import com.example.heistux.ui.accounts.collectionView.HasAccount
import com.example.heistux.ui.accounts.collectionView.NoAccount
import com.example.heistux.ui.accounts.connectAccount.ConnectAccount
import com.example.heistux.ui.accounts.openAccount.OpenAcc1
import com.example.heistux.ui.accounts.openAccount.OpenAcc2
import com.example.heistux.ui.accounts.openAccount.OpenAcc3
import com.example.heistux.ui.accounts.openAccount.OpenAcc4
import com.example.heistux.ui.transactions.collectionView.TransactionsCollectionView
import com.google.gson.Gson
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.institutes.Institute
import io.heist.store.model.core.parties.Party
import io.heist.store.model.core.transactions.Transaction
import java.math.BigDecimal

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(party: Party) {

    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = Screen.AccCollectionView.route) {

        composable( route = Screen.AccCollectionView.route ) {
            AccountsCollectionView(navController, party)
        }

        composable( route = Screen.AccCollectionView.route +"/{party}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            AccountsCollectionView(navController, p)
        }

        composable(route = Screen.ConnectAccount.route+"/{party}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            ConnectAccount( p, navController )

        }

        composable(route = Screen.OpenAccount1.route+"/{party}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            OpenAcc1( navController, p )

        }

        composable(route = Screen.OpenAccount2.route+"/{party}"+"/{bank}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                },
                navArgument("bank" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            val b=entry?.arguments?.get("bank") as String
            OpenAcc2( navController, p , b)

        }


        composable(route = Screen.OpenAccount3.route+"/{party}"+"/{bank}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                },
                navArgument("bank" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            OpenAcc3( navController, p , entry?.arguments?.get("bank") as String)

        }


        composable(route = Screen.OpenAccount4.route+"/{party}"+"/{bank}"+"/{type}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                },
                navArgument("bank" ) {
                    type= NavType.StringType
                },
                navArgument("type" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            OpenAcc4( navController, p , entry?.arguments?.get("bank") as String, entry?.arguments?.get("type") as String)

        }

        composable(route = Screen.TransactionCollectionView.route+"/{party}",
            arguments = listOf(
                navArgument("party" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            TransactionsCollectionView(party = p, navController = navController)
        }

        composable(route = Screen.TransactionCollectionView.route+"/{transactions}"+"/{party}",
            arguments = listOf(
                navArgument("transactions" ) {
                    type= NavType.StringType
                },
                navArgument("party" ) {
                    type= NavType.StringType
                }
            )
        ) {entry->
            val t = Gson().fromJson(entry?.arguments?.get("transactions") as String, List::class.java) as List<Transaction>
            val p = Gson().fromJson(entry?.arguments?.get("party") as String, Party::class.java) as Party
            TransactionsCollectionView(transactionlist = t, navController = navController, party = p)
        }


    }

}