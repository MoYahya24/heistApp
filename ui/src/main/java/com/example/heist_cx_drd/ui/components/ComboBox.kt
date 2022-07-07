package com.example.heist_cx_drd.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.heist_cx_drd.ui.theme.Blackish
import com.example.heist_cx_drd.ui.theme.White

@Composable
fun ComboBox(comboBoxText: ComboBoxText, list : List<String>, boxmodifier : Modifier = Modifier) {

    var selected = false
    var rowSize by remember { mutableStateOf(Size.Zero) }
    var text by remember { mutableStateOf("- select a bank -") }
    var expanded by remember { mutableStateOf(false) }
    Row( modifier = boxmodifier
        .fillMaxWidth()
        .border(width = 2.dp, color = White, shape = RectangleShape)
        .background(Blackish)
        .clickable { expanded = !expanded }
        .padding(10.dp)
        .onGloballyPositioned { layoutCoordinates ->
            rowSize = layoutCoordinates.size.toSize()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = text, modifier = Modifier.padding(8.dp), fontSize = 20.sp, color = White)
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false },
            Modifier
                .width(with(LocalDensity.current) { rowSize.width.toDp() })
                .background(Blackish/*Color(0xFF222222)*/)) {
            list.forEach{ item -> DropdownMenuItem(modifier = Modifier.padding(10.dp).fillMaxWidth(), onClick = {
                expanded=false
                selected=true
                text=item.toString()
                comboBoxText.text=item.toString()

            }) {
                Text(text = item.toString(), color = White)
            }
            }
        }
        Icon(imageVector = Icons.Filled.ArrowDropDown,  contentDescription = "",  Modifier.background(
            Blackish), tint = White)
    }

}

class ComboBoxText(){
    var text: String by mutableStateOf("")
}