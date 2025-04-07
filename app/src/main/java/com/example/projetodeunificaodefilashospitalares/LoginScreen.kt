package com.example.projetodeunificaodefilashospitalares

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Cor de fundo
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Seja bem-vindo ao",
            fontSize = 24.sp,
            color = Color.White, // Texto branco
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "FilaPRO",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold, // Definindo peso da fonte
            color = Color.White, // Texto branco
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.White) },
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0D47A1), // Azul escuro
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha", color = Color.White) },
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0D47A1),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("menu_principal")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0D47A1), // Azul escuro
                contentColor = Color.White // Texto branco
            )
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Esqueceu a senha?",
            modifier = Modifier.clickable {
                navController.navigate("redefinir_senha")
            },
            color = Color(0xFF64B5F6) // Azul claro para destaque
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Criar Conta",
            modifier = Modifier.clickable {
                navController.navigate("criar_conta")
            },
            color = Color(0xFF64B5F6) // Azul claro para destaque
        )
    }
}
