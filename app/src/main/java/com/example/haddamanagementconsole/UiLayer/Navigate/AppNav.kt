package com.example.haddamanagementconsole.UiLayer.Navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haddamanagementconsole.UiLayer.Screens.HomeScreen
import com.example.haddamanagementconsole.UiLayer.Screens.OrderScreen
import com.example.haddamanagementconsole.UiLayer.Screens.ProductScreen
import com.example.haddamanagementconsole.UiLayer.Screens.UserScreen

sealed class Nav(val route:String){
    object  Home : Nav("home")
    object User: Nav("user")
    object Product: Nav("product")
    object Order: Nav("order")
}


@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Nav.Home.route) {
        composable(Nav.Home.route){
            HomeScreen(navController)
        }
        composable(Nav.User.route){
            UserScreen()
        }
        composable(Nav.Product.route){
            ProductScreen()
        }
        composable(Nav.Order.route){
            OrderScreen()
        }

    }

}