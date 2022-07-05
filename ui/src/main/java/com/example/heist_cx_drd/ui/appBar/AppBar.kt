package com.example.heist_cx_drd.ui.appBar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.heist_cx_drd.ui.theme.Black

@Composable
fun AppBar(
    onNavigationClick : () -> Unit
){
    TopAppBar(
        modifier = Modifier.height(75.dp),
        title= { Text(text = "") },
        backgroundColor = Black,
        navigationIcon = {
            IconButton(onClick = onNavigationClick, modifier = Modifier.scale(1.7F).padding(8.dp)) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
        }
    )

}