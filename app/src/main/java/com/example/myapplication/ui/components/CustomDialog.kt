package com.example.myapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.R
import com.example.myapplication.data.repository.SettingViewModel
import com.example.myapplication.ui.theme.typography
import io.mhssn.colorpicker.ColorPickerDialog
import io.mhssn.colorpicker.ColorPickerType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(setShowDialog: (Boolean) -> Unit,
                 changeTheme: (Boolean) -> Unit) {

    val settingViewModel = SettingViewModel()
    val colorScheme = settingViewModel.getColors()
    val showColorPicker = remember { mutableStateOf(false)  }
    val tertiaryColor1 = remember { mutableStateOf(colorScheme.tertiary) }
    val primaryColor1 = remember { mutableStateOf(colorScheme.primary) }
    val secondaryColor1 = remember { mutableStateOf(colorScheme.secondary) }
    val selectedColorId = remember { mutableIntStateOf(1) }


    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.edit_theme_title_dialog),
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Icon(
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "",
                            tint = colorResource(android.R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ColorCard(showColorPicker = {showColorPicker.value = it}, selectedId = {selectedColorId.intValue = it}, defaultColor = primaryColor1.value, name = "primary", id = 1)

                    ColorCard(showColorPicker = {showColorPicker.value = it}, selectedId = {selectedColorId.intValue = it}, defaultColor = secondaryColor1.value, name = "secondary", id = 2)

                    ColorCard(showColorPicker = {showColorPicker.value = it}, selectedId = {selectedColorId.intValue = it}, defaultColor = tertiaryColor1.value, name = "tertiary", id = 3)

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                settingViewModel.setColors(
                                    primary1 = primaryColor1.value,
                                    secondary1 = secondaryColor1.value,
                                    tertiary1 = tertiaryColor1.value
                                )
                                setShowDialog(false)
                                changeTheme(true)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = stringResource(R.string.done))
                        }
                    }
                }
            }
        }
    }

    ColorPickerDialog(
        show = showColorPicker.value,

        type = ColorPickerType.Classic(),
        properties = DialogProperties(),
        onDismissRequest = {
            showColorPicker.value = false
        },
        onPickedColor = {
            showColorPicker.value = false
            when(selectedColorId.intValue){
                1 -> primaryColor1.value = it
                2 -> secondaryColor1.value = it
                3 -> tertiaryColor1.value = it
                else ->{}
            }
        },
    )

}

@Composable
fun ColorCard(showColorPicker:(Boolean)-> Unit, selectedId:(Int)-> Unit,defaultColor: Color, name: String , id: Int){

    Card(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                selectedId(id)
                showColorPicker(true)
            },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = defaultColor,
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = name,
                color = Color.White,
                style = typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth() )
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}

