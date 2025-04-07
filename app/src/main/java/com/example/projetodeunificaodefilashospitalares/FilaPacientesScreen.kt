package com.example.projetodeunificaodefilashospitalares

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projetodeunificaodefilashospitalares.viewmodel.PacienteViewModel
import com.example.projetodeunificaodefilashospitalares.model.Paciente

@Composable
fun FilaPacientesScreen(
    navController: NavController,
    viewModel: PacienteViewModel = viewModel()
) {
    val pacientes by viewModel.todosPacientes.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "FILA DE PACIENTES",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(pacientes) { paciente ->
                PacienteItem(paciente = paciente, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun PacienteItem(paciente: Paciente, viewModel: PacienteViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray, shape = MaterialTheme.shapes.medium)
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Paciente",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = paciente.nome,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.weight(1f))


            val sintomasPorGravidade = mapOf(
                "Leve" to listOf("Dor de cabeça", "Resfriado", "Dor nas costas"),
                "Moderado" to listOf("Fratura", "Asma", "Apendicite"),
                "Urgente" to listOf("Dengue", "H1N1", "Infarto", "AVC", "Hemorragia", "Convulsão", "Choque séptico", "Insuficiência respiratória")
            )

            val sintomasPaciente = paciente.sintomas.lowercase()


            val nivelGravidade = sintomasPorGravidade.entries.firstOrNull { (gravidade, sintomas) ->
                sintomas.any { sintomasPaciente.contains(it.lowercase()) }
            }?.key


            when (nivelGravidade) {
                "Leve" -> {
                    Text(
                        text = "🟢 Leve",
                        color = Color.Green,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                "Moderado" -> {
                    Text(
                        text = "🟠 Moderado",
                        color = Color(0xFFFFA500), // Laranja
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                "Urgente" -> {
                    Text(
                        text = "⬆ URGENTE",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                else -> {
                    Text(
                        text = "Sem gravidade identificada",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }


        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = paciente.sintomas,
            color = Color.LightGray,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.Gray, thickness = 0.5.dp)

        Button(
            onClick = { viewModel.removerPaciente(paciente) },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
        ) {
            Text("Atendido", color = Color.White)
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}
