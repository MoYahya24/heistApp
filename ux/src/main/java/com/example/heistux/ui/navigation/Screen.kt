package com.example.heistux.ui.navigation

sealed class Screen(val route: String ) {

    object AccCollectionView : Screen(route = "Acc_CollectionView")
    object AccOpened : Screen(route = "BackAcc_CollectionView")
    object ConnectAccount : Screen(route = "Connect_Account")
    object OpenAccount1 : Screen(route = "Open1")
    object OpenAccount11 : Screen(route = "Open11")
    object OpenAccount2 : Screen(route = "Open2")
    object OpenAccount3 : Screen(route = "Open3")
    object OpenAccount4 : Screen(route = "Open4")
    object TransactionCollectionView : Screen(route = "Transaction_CollectionView")

}
