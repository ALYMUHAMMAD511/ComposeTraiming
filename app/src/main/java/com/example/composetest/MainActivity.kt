package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MyText(stringResource(R.string.jetpack_compose))
                Spacer(modifier = Modifier.height(16.dp))
                MyTextField()
                Spacer(modifier = Modifier.height(16.dp))
                MyOutlineTextField()
                Spacer(modifier = Modifier.height(16.dp))
                MyButton()
                Spacer(modifier = Modifier.height(16.dp))
                MyRadioButtons()
                Spacer(modifier = Modifier.height(16.dp))
                MyFloatingActionButton()
                Spacer(modifier = Modifier.height(16.dp))
                MyProgressBar()
                Spacer(modifier = Modifier.height(16.dp))
                MyAlertDialog()
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    MyRow()
                }
            }

        }
    }
}

@Composable
fun MyText(text: String) {
    Text(
        text = text,
        color = Color.Blue,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MyTextField() {
    val textValue = remember {
        mutableStateOf("")
    }

    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {
            Text(text = stringResource(R.string.enter_your_name))
        }
    )
}

@Composable
fun MyOutlineTextField() {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {
            Text(text = stringResource(R.string.enter_your_name))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Color.Blue,
            focusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyButton() {
    val text = remember {
        mutableStateOf("ENTER YOUR NAME")
    }

    Button(
        onClick = {
            text.value = "ALY MUHAMMAD"
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text(text = text.value)
    }
}

@Composable
fun MyRadioButtons() {
    val radioButtons = listOf(1, 2, 3)
    val selectedRadioButton = remember {
        mutableIntStateOf(radioButtons.first())
    }

    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedRadioButton.intValue

            Row {
                RadioButton(
                    selected = isSelected,
                    onClick = {
                        selectedRadioButton.intValue = index
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                        unselectedColor = Color.Red
                    )
                )
            }
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        content = {
            Icon(Icons.Default.Add, contentDescription = stringResource(R.string.add))
        },
        contentColor = Color.Blue
    )
}

@Composable
fun MyProgressBar() {
    CircularProgressIndicator(
        color = Color.Blue,
        strokeWidth = 5.dp,
        modifier = Modifier.height(100.dp)
    )
}

@Composable
fun MyAlertDialog() {
    val showAlertDialog = remember {
        mutableStateOf(true)
    }

    if (showAlertDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showAlertDialog.value = false
            },
            title = {
                Text(text = stringResource(R.string.app_name))
            },
            text = {
                Text(text = stringResource(R.string.enter_your_name))
            },
            confirmButton = {
                Button(
                    onClick = {
                        showAlertDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = stringResource(R.string.add))
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showAlertDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = stringResource(R.string.cancel))
                }
            }
        )
    }
}

@Composable
fun MyRow() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Text(
            text = stringResource(R.string.jetpack_compose),
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string.jetpack_compose),
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string.jetpack_compose),
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
    }
}