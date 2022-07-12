package com.example.heist_cx_drd.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.heist_cx_drd.R
import com.example.heist_cx_drd.ui.theme.White


@Composable
fun HeistTextField(modifier: Modifier= Modifier, fieldLabel:String, icon: ImageVector, fieldType: KeyboardType, text : FieldText) {

    var value by remember{ mutableStateOf("")}

    OutlinedTextField(textStyle = LocalTextStyle.current.copy(color = White),value = value,
        onValueChange = {newText ->
            value = newText
            text.text= newText
    },
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

@Composable
fun PasswordTextField(modifier: Modifier= Modifier, fieldLabel:String, icon: ImageVector, fieldType: KeyboardType, text : FieldText) {

    var value by remember{ mutableStateOf("")}
    var pvisibility by remember { mutableStateOf(false)}

    val visibilityIcon = if(pvisibility) {
        Icons.Outlined.ArrowDropDown
    }
    else {
        Icons.Filled.ArrowDropDown
    }

    OutlinedTextField(textStyle = LocalTextStyle.current.copy(color = White),value = value,
        onValueChange = {newText ->
            value = newText
            text.text= newText.trim()
        },
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
        ),
        modifier = modifier,
        trailingIcon = {
            IconButton(onClick = { pvisibility = !pvisibility }) {
                Icon(imageVector = visibilityIcon, contentDescription = "visibility", tint= Color(0xFFFFFFFF))
            }
        },
        visualTransformation = if (pvisibility) {
            VisualTransformation.None
        }
        else {
            PasswordVisualTransformation()
        }
    )
}

class FieldText(){
    var text: String by mutableStateOf("")
}