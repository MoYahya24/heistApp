package com.example.heist_cx_drd.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.heist_cx_drd.ui.theme.White


@Composable
fun HeistTextField(modifier: Modifier= Modifier,defaultText: String="", fieldLabel:String, icon: ImageVector, fieldType: KeyboardType, value: String, onvaluechange: (String)-> Unit) {

    OutlinedTextField(textStyle = LocalTextStyle.current.copy(color = White),value = value, onValueChange = { onvaluechange},
        label = {
            Text(text = fieldLabel, color = Color(0xFFFFFFFF))
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFFFFFFF),
            unfocusedBorderColor = Color(0xFFFFFFFF)
        ),
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "", tint= Color(0xFFFFFFFF))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = fieldType
        ), modifier = modifier
    )
}