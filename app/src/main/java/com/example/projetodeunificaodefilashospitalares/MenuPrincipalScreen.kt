package com.example.projetodeunificaodefilashospitalares
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.Color

@Composable
fun MenuPrincipalScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "FilaPRO",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                navController.navigate("cadastro")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF003366),
                contentColor = Color.White
            )
        ) {
            Text("Cadastrar Paciente")
        }

        Button(
            onClick = {
                navController.navigate("fila_pacientes")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF003366),
                contentColor = Color.White
            )
        ) {
            Text("Visualizar Fila")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPrincipalScreenPreview() {
    MenuPrincipalScreen(navController = rememberNavController())
}
