package com.example.haddamanagementconsole.UiLayer.Navigate

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haddamanagementconsole.UiLayer.Screens.HomeScreen
import com.example.haddamanagementconsole.UiLayer.Screens.Order.DetailOrderScreen
import com.example.haddamanagementconsole.UiLayer.Screens.Order.OrderScreen
import com.example.haddamanagementconsole.UiLayer.Screens.Product.ProductScreen
import com.example.haddamanagementconsole.UiLayer.Screens.User.SpecificUserScreen
import com.example.haddamanagementconsole.UiLayer.Screens.User.UserScreen
import com.example.haddamanagementconsole.UiLayer.Screens.User.UserSpecificOrder
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel

sealed class Nav(val route:String){
    object  Home : Nav("home")
    object User: Nav("user")
    object Product: Nav("product")
    object Order: Nav("order")
    object SpecificUser : Nav("specificuser") // Include {userId} placeholder
    object UserOrder :Nav("specificorder")
    object DetailOrder:Nav("detailorder")
}


@Composable
fun AppNav() {
    val navController = rememberNavController()
    val viewmodel: ConsoleViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Nav.Home.route) {
        composable(Nav.Home.route){
            HomeScreen(navController)
        }
        composable(Nav.User.route){
            UserScreen(navController,viewmodel)
        }
        composable(Nav.Product.route){
            ProductScreen()
        }
        composable(Nav.Order.route){
            OrderScreen(navController,viewmodel)
        }
        composable(Nav.SpecificUser.route){
            SpecificUserScreen(viewmodel,navController)
        }
        composable(Nav.UserOrder.route){
            UserSpecificOrder(viewmodel,navController)
        }
        composable(Nav.DetailOrder.route){
            DetailOrderScreen(viewmodel,navController)
        }

    }

}