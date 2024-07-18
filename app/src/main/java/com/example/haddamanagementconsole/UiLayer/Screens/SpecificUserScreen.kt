package com.example.haddamanagementconsole.UiLayer.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddamanagementconsole.DataLayer.Models.UsersItem

@Composable
@Preview(showSystemUi = true)
fun SpecificUserScreen() {
    val userList :ArrayList<UsersItem> = arrayListOf()
    userList.add(UsersItem("Delhi","Vishal@Gmail.com",1,"Vishal","+91 8262798269","CheckCheckVishu"))

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        LazyColumn {
            items(userList) {
                specificuserItem(it)
            }
        }
    }
}

@Composable
fun specificuserItem(usersItem: UsersItem) {
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
            Text(
                text ="Id : ${usersItem.userID}",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text ="Name : ${usersItem.name}",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text ="Email : ${usersItem.email}",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text ="Phone No : ${usersItem.phone_no}",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text ="Address : ${usersItem.address}",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text ="Click Here to See ${usersItem.name} All Order",
                fontFamily = FontFamily.SansSerif,
                fontSize =18.sp,
                modifier = Modifier.padding(top = 15.dp)
            )

        }
    }
}