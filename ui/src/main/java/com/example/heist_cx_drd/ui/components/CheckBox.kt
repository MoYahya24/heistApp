package com.example.heist_cx_drd.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heist_cx_drd.ui.theme.Blackish
import com.example.heist_cx_drd.ui.theme.White
import com.example.heist_cx_drd.ui.theme.HeistcxdrdTheme

class CheckedOption(text: String){
    var text: String by mutableStateOf(text)
}

@Composable
fun GroupedCheckbox(
    list: List<String>,
    size:Size,
    modifier: Modifier=Modifier,
    checkedOption: CheckedOption
){
    var states = remember { mutableStateListOf(false)}
    for(i in 1 until list.size) {
        states.add( false)
    }

    Column(modifier = modifier) {
        list.forEachIndexed{index, item->
            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start=20.dp, top=20.dp, bottom = size.padding.dp)){
                Checkbox(checked = states[index],
                    onCheckedChange = { states[index]=!states[index]
                        if(states[index]==true) {
                            checkedOption.text=item
                            for (i in states.indices) {
                                if (i != index) {
                                    states[i] = false
                                }
                            }
                        }
                    },
                    modifier = Modifier.scale(size.scale),
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = White,
                        uncheckedColor = White,
                        checkedColor = Blackish
                    )
                )
                Text(color= White,text = item, modifier = Modifier.padding(start = size.padding.dp), fontWeight = FontWeight.ExtraBold, fontSize = size.size.sp)
            }


        }
    }
}

enum class Size(val size: Float, val scale: Float, val padding: Int) {
    SMALL(16f, 1.5F, 5),
    MEDIUM(18f, 2F, 10),
    LARGE(22f, 2.5F, 17),
    HUGE(28f, 3F, 23)
}

