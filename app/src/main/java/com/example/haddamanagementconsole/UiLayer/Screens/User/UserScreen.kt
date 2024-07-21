package com.example.haddamanagementconsole.UiLayer.Screens.User

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.haddamanagementconsole.DataLayer.Models.UsersItem
import com.example.haddamanagementconsole.UiLayer.Navigate.Nav
import com.example.haddamanagementconsole.UiLayer.ViewModel.ConsoleViewModel

@Composable
fun UserScreen(navController: NavHostController, viewmodel: ConsoleViewModel) {

    val userList = viewmodel.AllUser.collectAsState()

    LazyColumn {
        items(userList.value){
            UserScreenItem(it,navController,viewmodel)
        }
    }
}

@Composable
fun UserScreenItem(
    usersItem: UsersItem,
    navController: NavHostController,
    viewmodel: ConsoleViewModel
) {
    Card (modifier = Modifier
        .fillMaxWidth(.95f)
        .height(150.dp)
        .padding(vertical = 5.dp, horizontal = 8.dp).clickable {
            viewmodel.getId(usersItem.userID)
            navController.navigate(Nav.SpecificUser.route)
        }){

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "User Id : ${usersItem.userID}",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Name : ${ usersItem.name }",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp, textAlign = TextAlign.Start,
                    )
            }
        }
    }
}