package com.example.projetodeunificaodefilashospitalares.repository

import com.example.projetodeunificaodefilashospitalares.dao.PacienteDao
import com.example.projetodeunificaodefilashospitalares.model.Paciente
import kotlinx.coroutines.flow.Flow

class PacienteRepository(private val pacienteDao: PacienteDao) {

    val todosPacientes: Flow<List<Paciente>> = pacienteDao.listarPacientes() // Acessando a função que retorna Flow

    suspend fun adicionarPaciente(paciente: Paciente) {
        pacienteDao.inserirPaciente(paciente)
    }

    suspend fun removerPaciente(paciente: Paciente) {
        pacienteDao.removerPaciente(paciente)
    }
}
