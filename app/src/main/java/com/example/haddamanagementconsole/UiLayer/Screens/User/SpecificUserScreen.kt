package com.example.haddamanagementconsole.UiLayer.Screens.User

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.haddamanagementconsole.DataLayer.Models.UserProfile
import com.example.haddamanagementconsole.UiLayer.Navigate.Nav
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel

@Composable
fun SpecificUserScreen(viewmodel: ConsoleViewModel,navController: NavHostController) {

   val  id = viewmodel.id.value
    Log.d("ID","$id")
    viewmodel.specificUser(id)
    val userList= viewmodel.specificUserInfo.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        specificuserItem(usersItem = userList.value,navController)
    }
}

@Composable
fun specificuserItem(usersItem: UserProfile?, navController: NavHostController) {
    Card(
        modifier = Modifier
            .height(400.dp)
            .padding(vertical = 5.dp, horizontal = 8.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.size(100.dp)) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }

            Column {


                Text(
                    text = "Id : ${usersItem?.userID}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Name : ${usersItem?.name}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Email : ${usersItem?.email}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Phone No : ${usersItem?.phone_no}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Address : ${usersItem?.address}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Text(
                text = "Click Here to See ${usersItem?.name} All Order",
                fontFamily = FontFamily.SansSerif,
                fontSize = 10.sp,
                modifier = Modifier.padding(top = 15.dp).clickable {
                    navController.navigate(Nav.UserOrder.route)
                }
            )

        }
    }
}