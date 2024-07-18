package com.example.haddamanagementconsole.UiLayer.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddamanagementconsole.DataLayer.Models.UsersItem

@Composable
@Preview(showSystemUi = true)
fun UserScreen(){
    val userList :ArrayList<UsersItem> = arrayListOf()
    userList.add(UsersItem("Delhi","Vishal@Gmail.com",1,"Vishal","+91 8262798269","CheckCheckVishu"))
    userList.add(UsersItem("Mumbai","Raman@Gmail.com",2,"Raman","+91 8264878269","CheckCheckRaman"))

    LazyColumn {
        items(userList){
            UserScreenItem(it)
        }
    }
}

@Composable
fun UserScreenItem(usersItem: UsersItem) {
    Card (modifier = Modifier
        .fillMaxWidth(.95f)
        .height(150.dp)
        .padding(vertical = 5.dp, horizontal = 8.dp)){

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = usersItem.userID.toString(),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp
                    )
                    Text(
                        text = usersItem.name,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp, textAlign = TextAlign.Start,
                    )
            }
        }
    }
}