package com.example.projetodeunificaodefilashospitalares

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment

@Composable
fun RedefinirSenhaScreen(navController: NavController) {
    var codigoSms by remember { mutableStateOf("") }
    var novaSenha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var isCodigoEnviado by remember { mutableStateOf(false) }
    var isCodigoConfirmado by remember { mutableStateOf(false) }
    var isSenhaCriada by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Cor de fundo
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Redefinir Senha",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,  // Texto branco
            modifier = Modifier.padding(bottom = 16.dp)
        )


        if (!isCodigoConfirmado) {
            Text(
                text = "Insira o código enviado via SMS",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,  // Texto branco
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = codigoSms,
                onValueChange = { codigoSms = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF0D47A1), // Azul escuro
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { isCodigoEnviado = true },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isCodigoEnviado,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF003366), // Azul escuro
                    contentColor = Color.White // Texto branco
                )
            ) {
                Text("Receber Código SMS")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isCodigoEnviado) {
                Button(
                    onClick = { isCodigoConfirmado = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF003366), // Azul escuro
                        contentColor = Color.White // Texto branco
                    )
                ) {
                    Text("Confirmar Código")
                }
            }
        }


        if (isCodigoConfirmado && !isSenhaCriada) {
            OutlinedTextField(
                value = novaSenha,
                onValueChange = { novaSenha = it },
                label = { Text("Criar Nova Senha") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF0D47A1), // Azul escuro
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = confirmarSenha,
                onValueChange = { confirmarSenha = it },
                label = { Text("Confirmar Nova Senha") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF0D47A1), // Azul escuro
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (novaSenha == confirmarSenha) {
                        isSenhaCriada = true
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF003366), // Azul escuro
                    contentColor = Color.White // Texto branco
                )
            ) {
                Text("Salvar Nova Senha")
            }
        }


        if (isSenhaCriada) {
            Text(
                text = "Senha redefinida com sucesso!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF003366),
                    contentColor = Color.White
                )
            ) {
                Text("Voltar para o Login")
            }
        }
    }
}
