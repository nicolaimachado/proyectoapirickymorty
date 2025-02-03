package com.nicolaischirmer.proyectoapirickymorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nicolaischirmer.proyectoapirickymorty.firebase.AuthManager
import com.nicolaischirmer.proyectoapirickymorty.ui.screen.ForgotPasswordScreen
import com.nicolaischirmer.proyectoapirickymorty.ui.screen.HomeScreen
import com.nicolaischirmer.proyectoapirickymorty.ui.screen.LoginScreen
import com.nicolaischirmer.proyectoapirickymorty.ui.screen.SignUpScreen


@Composable
fun Navigation(auth: AuthManager) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = login
    ) {
        composable<login> {
            LoginScreen(
                auth,
                { navController.navigate(signUp) },
                {
                    navController.navigate(listaPersonajes) {
                        popUpTo(login) { inclusive = true }
                    }
                },
                { navController.navigate(forgotPassword) }
            )
        }
        composable<signUp> {
            SignUpScreen(
                auth
            ) { navController.popBackStack() }
        }

        composable <forgotPassword> {
            ForgotPasswordScreen(
                auth
            ) { navController.navigate(login) {
                popUpTo(login){ inclusive = true }
            } }
        }

        composable<listaPersonajes> {
            HomeScreen(
                auth,
                viewModel(),
                {
                    navController.navigate(login) {
                        popUpTo(listaPersonajes){ inclusive = true }
                    }
                }
            )
        }
    }
}
