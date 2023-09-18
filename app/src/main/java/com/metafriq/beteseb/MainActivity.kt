package com.metafriq.beteseb

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.metafriq.beteseb.logIn.LogInActivity
import com.metafriq.beteseb.signIn.SignInActivity
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navigation()
        }
    }

    @Composable
 fun navigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "splash_screen"
        ){
            composable("splash_screen"){
                SplashScreen(navController = navController)
            }
            composable("main_screen"){
                MainScreen(navController = navController)
            }
        }
    }

    @Composable
    fun SplashScreen(navController: NavController){
        LaunchedEffect(key1 = true){
            delay(5000L)
            navController.navigate("main_screen")
        }
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
            )
            Text(text = "ቤተሰብ",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
    @Composable
    fun MainScreen(navController: NavController){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
            )
            Text(text = "Welcome to your preferred marketplace",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
            Button(onClick = {
                val navigate = Intent(this@MainActivity, SignInActivity::class.java)
                startActivity(navigate)
            }) {
                Text(text = "Sign Up", fontSize = 16.sp)
            }
            Text(text = "Or",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
                )
            Button(onClick = {
                val navigate = Intent(this@MainActivity, LogInActivity::class.java)
                startActivity(navigate)
            }) {
                Text(text = "Log In", fontSize = 16.sp)
            }
        }
    }
}