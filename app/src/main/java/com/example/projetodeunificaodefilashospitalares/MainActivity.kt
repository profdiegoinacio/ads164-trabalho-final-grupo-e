package com.example.projetodeunificaodefilashospitalares

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetodeunificaodefilashospitalares.ui.theme.PROJETODEUNIFICAÇÃODEFILASHOSPITALARESTheme
import com.example.projetodeunificaodefilashospitalares.LoginScreen
import com.example.projetodeunificaodefilashospitalares.CadastroPacienteScreen
import com.example.projetodeunificaodefilashospitalares.MenuPrincipalScreen
import com.example.projetodeunificaodefilashospitalares.AppNavHost



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavHost()
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PROJETODEUNIFICAÇÃODEFILASHOSPITALARESTheme {
        Greeting("Android")
    }
}