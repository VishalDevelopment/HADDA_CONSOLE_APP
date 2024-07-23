package com.example.haddamanagementconsole.UiLayer.Screens.Order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.haddamanagementconsole.DataLayer.Models.MyOrderResponse
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel

//Ui Work Completed



@Composable
//@Preview(showSystemUi = true)
fun DetailOrderScreen(viewmodel: ConsoleViewModel, navController: NavHostController) {
    val orderId = viewmodel.orderid.value
    val viewmodel :ConsoleViewModel = hiltViewModel()
    viewmodel.Order(orderId)
    val specificOrder = viewmodel.Order.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            DetailOrderScreenItem(specificOrder.value)
        }
    }

}

@Composable
fun DetailOrderScreenItem(specificOrder: MyOrderResponse?) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {

                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(text = "User Detail", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                        Text(
                            text = "Id : ${specificOrder?.userID}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Name : ${specificOrder?.name}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Email : ${specificOrder?.email}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Phone No : +91 ${specificOrder?.phone_no}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Address : ${specificOrder?.address}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(text = "Order Detail", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                        Text(
                            text = "Category : ${specificOrder?.category}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Unir : ${specificOrder?.unit}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        val weightf = remember {
                            mutableStateOf("${specificOrder?.weight}")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Weight : ",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                            OutlinedTextField(value = weightf.value, onValueChange = {
                                weightf.value = it
                            },modifier = Modifier
                                .padding(vertical = 8.dp)
                                .height(48.dp)
                                .width(80.dp), singleLine = true)

                        }

                        Text(
                            text = "Price : ${specificOrder?.price}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Status : ${specificOrder?.status}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Date : ${specificOrder?.orderDate}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Time : ${specificOrder?.orderTiming}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)){
                            Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Green), modifier = Modifier
                                .height(46.dp)
                                .width(100.dp)) {
                                Text(text = "Successfull", fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(vertical = 8.dp))
                            }
                            Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Red),modifier = Modifier
                                .height(46.dp)
                                .width(100.dp)) {
                                Text(text = "Failed", fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    modifier = Modifier.padding(vertical = 8.dp))
                            }
                        }
                    }

        }
    }
}

