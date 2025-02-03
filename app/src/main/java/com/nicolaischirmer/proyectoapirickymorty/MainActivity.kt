package com.nicolaischirmer.proyectoapirickymorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nicolaischirmer.proyectoapirickymorty.firebase.AuthManager
import com.nicolaischirmer.proyectoapirickymorty.ui.navigation.Navigation
import com.nicolaischirmer.proyectoapirickymorty.ui.theme.ProyectoAPIRickYMortyTheme

class MainActivity : ComponentActivity() {
    val auth = AuthManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAPIRickYMortyTheme {
                Navigation(auth)
            }
        }
    }
}
