package com.example.haddamanagementconsole.UiLayer.Screens.User

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.haddamanagementconsole.DataLayer.Models.MyOrderResponse
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel

@Composable
fun UserSpecificOrder(viewmodel: ConsoleViewModel, navController: NavHostController) {

    val id = viewmodel.id.value
    viewmodel.UserOrder(id)
    val SpecificOrder = viewmodel.specificOrder.collectAsState()
    Log.d("IDORDER", "$id")
    Log.d("ORDERS", "${SpecificOrder.value}")

    Column(
        Modifier
            .fillMaxSize()
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "UserId : Random123@",
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Name : Vishal Goswami",
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
        LazyColumn(Modifier.fillMaxSize()) {
            items(SpecificOrder.value) {
                OrderListViewItem(it)
            }
        }
    }
}

@Composable

fun OrderListViewItem(orderItems: MyOrderResponse) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(.95f)
            .border(0.5.dp, Color.Black, shape = RectangleShape)
            .padding(vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.padding(8.dp)) {
                //Unit And Status is Missing
                Text(text = "Category : ${orderItems.category}", fontSize = 18.sp)
                Text(text = "Unit : ${orderItems.unit}", fontSize = 18.sp)
                Text(text = "Weight : ${orderItems.weight} kg", fontSize = 18.sp)
                Text(text = "Price : ₹ ${orderItems.price}", fontSize = 18.sp)
                Text(text = "Status : ${orderItems.status}", fontSize = 18.sp)

            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ) {
            Text(text = "Date : ${orderItems.orderDate}", fontSize = 15.sp)
            Text(text = "Time : ${orderItems.orderTiming}", fontSize = 15.sp)
        }
    }
}

