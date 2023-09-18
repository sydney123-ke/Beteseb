package com.metafriq.beteseb.logIn

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.metafriq.beteseb.R
import com.metafriq.beteseb.signIn.ui.theme.PrimaryColor

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Log In",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                MyTextField()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    val emailValue = remember {
        mutableStateOf("")
    }
    val passwordValue = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        false
    }
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = { emailValue.value =it },
        label = { Text(text = "Email Address")},
        placeholder = { Text(text = "Enter email address")},
        singleLine = true,
        modifier = Modifier.fillMaxWidth(8.8f)
    )
    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = {passwordValue.value = it},
        trailingIcon = {
            IconButton(onClick = {  }) {}
        }
    )
}

