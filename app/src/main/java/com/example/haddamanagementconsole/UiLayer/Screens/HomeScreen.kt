package com.example.haddamanagementconsole.UiLayer.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.haddamanagementconsole.UiLayer.Navigate.Nav
import com.example.haddamanagementconsole.ui.theme.Pink40
import com.example.haddamanagementconsole.ui.theme.Purple40


data class items(
    val category: String,
    val index: Int,
)

@Composable

fun HomeScreen(navController: NavHostController) {
    var itemList = mutableListOf<items>(items("Users", 0), items("Products", 1), items("Orders", 2))

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(3.dp)) {
            items(itemList) {
                HomeScreenItems(it,navController)
            }
        }

    }

}


@Composable
fun HomeScreenItems(item: items, navController: NavHostController) {

    Card(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp)
            .clickable {
                when(item.index){
                    0 ->{
                        navController.navigate(Nav.User.route)
                    }
                    1->{
                        navController.navigate(Nav.Product.route)
                    }
                    2->{
                        navController.navigate(Nav.Order.route)
                    }
                }
            }, border = BorderStroke(
            1.dp, brush = Brush.sweepGradient(
                colors = listOf(
                    Pink40, Purple40
                )
            )
        )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "${item.category}",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }

}

