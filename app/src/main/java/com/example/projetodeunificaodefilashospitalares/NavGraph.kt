package com.example.projetodeunificaodefilashospitalares

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("cadastro") { CadastroPacienteScreen(navController) }
        composable("menu_principal") { MenuPrincipalScreen(navController) }
        composable("criar_conta") { CriarContaScreen(navController) } //professor aqui é a nova tela de cadastro
        composable("redefinir_senha") { RedefinirSenhaScreen(navController) }
        composable("fila_pacientes") { FilaPacientesScreen(navController) }


    }
}

