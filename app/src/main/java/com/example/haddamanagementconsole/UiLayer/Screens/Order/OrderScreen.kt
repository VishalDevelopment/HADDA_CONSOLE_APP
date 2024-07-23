package com.example.haddamanagementconsole.UiLayer.Screens.Order

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.haddamanagementconsole.DataLayer.Models.MyOrderResponse
import com.example.haddamanagementconsole.UiLayer.Navigate.Nav
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel

@Composable
fun OrderScreen(navController: NavHostController, viewmodel: ConsoleViewModel) {

    val AllOrder = viewmodel.AllOrder.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
        LazyColumn {
            items(AllOrder.value){
                OrderScreenItem(it,navController,viewmodel)
            }
        }
    }

}

@Composable
fun OrderScreenItem(
    allOrderItem: MyOrderResponse,
    navController: NavHostController,
    viewmodel: ConsoleViewModel
) {
    Card(
border = BorderStroke(1.dp,Color.Black),
        modifier = Modifier
            .fillMaxWidth(.95f)
            .padding(vertical = 4.dp, horizontal = 8.dp).clickable {
                viewmodel.getOrderId(allOrderItem.id)
                navController.navigate(Nav.DetailOrder.route)
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.padding(8.dp)) {
                //Unit And Status is Missing
                Text(text = "Category : ${allOrderItem.category}", fontSize = 18.sp)
                Text(text = "Unit : ${allOrderItem.unit}", fontSize = 18.sp)
                Text(text = "Weight : ${allOrderItem.weight} kg", fontSize = 18.sp)
                Text(text = "Price : ₹ ${allOrderItem.price}", fontSize = 18.sp)
                Text(text = "Status : ${allOrderItem.status}", fontSize = 18.sp)

            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ) {
            Text(text = "Date : ${allOrderItem.orderDate}", fontSize = 15.sp)
            Text(text = "Time : ${allOrderItem.orderTiming}", fontSize = 15.sp)
        }
    }
}