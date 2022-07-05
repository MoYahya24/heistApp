package com.example.heistux.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heist_cx_drd.ui.appBar.AppBar
import com.example.heist_cx_drd.ui.theme.Black
import com.example.heist_cx_drd.ui.theme.Blackish
import com.example.heist_cx_drd.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun DrawerHeader() {
Box(
modifier = Modifier
    .background(color = Blackish)
    .fillMaxWidth()
    .padding(top = 80.dp),
    contentAlignment = Alignment.BottomStart

){
    Text(modifier = Modifier.padding(20.dp),text = "WIDGETS", fontSize = 45.sp, color = White, fontWeight = FontWeight.ExtraBold)
}

}

@Composable
fun DrawerBody(
    items : List<MenuItem>,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
) {

    LazyColumn(modifier.background(color = Color(0xFF000000))) {
        items(items) {item->
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF000000))
                    .clickable {
                        onItemClick
                    }
                    .padding(16.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = "", tint = White)
                Text(text = item.title, color = White)
            }

        }
    }

}

@Composable
fun NavDrawer( pageContent: (@Composable() () -> Unit)) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        content = { pageContent() },
        modifier=Modifier.wrapContentSize(),
        scaffoldState = scaffoldState,
        topBar = {
                 AppBar {
                     scope.launch {
                         scaffoldState.drawerState.open()
                     }
                 }
        },
        drawerContent = {
            DrawerHeader()
            DrawerBody(items = listOf(
                MenuItem("acc", "ACCOUNTS", Icons.Filled.Person, itemClick = { }),
                MenuItem("transactions", "TRANSACTIONS", Icons.Filled.Share, itemClick = {})

            ),
                onItemClick = {
                    println(it.title)
                }
            )
        },
        drawerGesturesEnabled = true,
        drawerBackgroundColor = Black

    )
}
