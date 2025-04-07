package com.example.projetodeunificaodefilashospitalares.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pacientes") // Nome da tabela
data class Paciente(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // id será gerado automaticamente
    val nome: String,
    val cpf: String,
    val endereco: String,
    val sintomas: String,
    val prioridade: Int // Prioridade do paciente (quanto maior, mais urgente)
)
