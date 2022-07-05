package com.example.heist_cx_drd.ui.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heist_cx_drd.ui.theme.White


@Composable
fun HeistButton(action: (() -> Unit)?, size: ButtonSize, text : String, textWeight: FontWeight?= FontWeight.ExtraBold, modifier: Modifier?=Modifier, hasBorder : Boolean = true){

    var color = White

    if(hasBorder==false) {
        color= Color.Transparent
    }

    Button(onClick = action!!, modifier = modifier!!
        .wrapContentSize()
        .border(width = 2.dp, color = color, shape = RectangleShape))
    {
        Text(text = text, fontWeight = textWeight!! , fontSize = size.size.sp)

    }
}

enum class ButtonSize(val size: Float) {
    SMALL(16f),
    MEDIUM(18f),
    LARGE(22f),
    HUGE(26f)
}