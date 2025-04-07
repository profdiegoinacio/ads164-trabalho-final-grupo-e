package com.example.projetodeunificaodefilashospitalares.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetodeunificaodefilashospitalares.database.`PacienteDatabase`
import com.example.projetodeunificaodefilashospitalares.model.Paciente
import com.example.projetodeunificaodefilashospitalares.repository.PacienteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PacienteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PacienteRepository

    val todosPacientes: Flow<List<Paciente>>

    init {
        val db = `PacienteDatabase`.getDatabase(application)
        val pacienteDao = db.pacienteDao()
        repository = PacienteRepository(pacienteDao)
        todosPacientes = repository.todosPacientes
    }

    fun adicionarPaciente(paciente: Paciente) {
        viewModelScope.launch {
            repository.adicionarPaciente(paciente)
        }
    }

    fun removerPaciente(paciente: Paciente) {
        viewModelScope.launch {
            repository.removerPaciente(paciente)
        }
    }
}
