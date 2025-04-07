package com.example.projetodeunificaodefilashospitalares.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.projetodeunificaodefilashospitalares.model.Paciente
import kotlinx.coroutines.flow.Flow

@Dao
interface PacienteDao {

    @Insert
    suspend fun inserirPaciente(paciente: Paciente)

    @Delete
    suspend fun removerPaciente(paciente: Paciente)

    @Query("SELECT * FROM pacientes ORDER BY prioridade DESC, id ASC") // Ajustando o nome da tabela e dos campos
    fun listarPacientes(): Flow<List<Paciente>>
}
