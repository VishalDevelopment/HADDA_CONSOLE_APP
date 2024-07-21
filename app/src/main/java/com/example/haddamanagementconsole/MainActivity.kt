package com.example.haddamanagementconsole

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.haddamanagementconsole.UiLayer.Navigate.AppNav
import com.example.haddamanagementconsole.UiLayer.Screens.HomeScreen
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel
import com.example.haddamanagementconsole.ui.theme.HaddaManagementConsoleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HaddaManagementConsoleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 Box(modifier = Modifier
                     .padding(innerPadding)
                     .fillMaxSize()){
                     AppNav()
                 }
                }
            }
        }
    }
}







