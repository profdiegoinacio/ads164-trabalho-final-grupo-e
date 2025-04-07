package com.example.projetodeunificaodefilashospitalares

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projetodeunificaodefilashospitalares.viewmodel.PacienteViewModel
import com.example.projetodeunificaodefilashospitalares.model.Paciente

@Composable
fun CadastroPacienteScreen(navController: NavController, viewModel: PacienteViewModel = viewModel()) {
    val context = LocalContext.current


    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var sintomas by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "CADASTRO",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally) // Centraliza o texto
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "Insira os seus dados e clique no botão Cadastrar, para acompanhar a sua posição na fila.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.White) // Cor do texto
        )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.White) // Cor do texto
        )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = endereco,
            onValueChange = { endereco = it },
            label = { Text("Endereço") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.White) // Cor do texto
        )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = sintomas,
            onValueChange = { sintomas = it },
            label = { Text("Sintomas") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.White) // Cor do texto
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (nome.isNotBlank() && cpf.isNotBlank() && endereco.isNotBlank() && sintomas.isNotBlank()) {
                    val paciente = Paciente(
                        nome = nome,
                        cpf = cpf,
                        endereco = endereco,
                        sintomas = sintomas,
                        prioridade = 0 // Definindo uma prioridade, já que é um campo obrigatório.
                    )
                    viewModel.adicionarPaciente(paciente)
                    Toast.makeText(context, "Paciente cadastrado!", Toast.LENGTH_SHORT).show()
                    navController.navigate("menu_principal")
                } else {
                    Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1), contentColor = Color.White)
        ) {
            Text("Cadastrar")
        }
    }
}
