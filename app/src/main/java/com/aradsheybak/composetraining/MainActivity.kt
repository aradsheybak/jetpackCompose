package com.aradsheybak.composetraining

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposablePreview()
        }
    }

    @Composable
    @Preview

    private fun ComposablePreview() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Texty("Arad")
            textField()
            MyButton()
        }
    }

    @Composable
    private fun Texty(name: String) {

        Text(
            "Hello" + stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontStyle = FontStyle.Italic,
            softWrap = true,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

    }

    @Composable
    private fun textField() {
        val textValue = remember {
            mutableStateOf("")
        }

        val primaryColor = colorResource(id = R.color.purple_500)

        OutlinedTextField(
            label = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = colorResource(id = R.color.white)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primaryColor,
                focusedLabelColor = primaryColor,
                cursorColor = primaryColor,
                unfocusedBorderColor = colorResource(id = R.color.white)

            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            value = textValue.value,
            onValueChange = { textValue.value = it })


    }


    @Composable
    private fun MyButton() {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_700)),
            border = BorderStroke(
                1.dp,
                colorResource(id = R.color.purple_700)
            ),
            shape = MaterialTheme.shapes.large
        ) {
            Text(text = "Next", color = colorResource(id = R.color.white))

        }
    }

}
