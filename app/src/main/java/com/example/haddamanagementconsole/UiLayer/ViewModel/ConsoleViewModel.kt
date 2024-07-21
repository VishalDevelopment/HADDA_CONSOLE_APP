package com.example.haddamanagementconsole.UiLayer.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haddamanagementconsole.DataLayer.Models.UserProfile
import com.example.haddamanagementconsole.DataLayer.Repo.ConsoleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsoleViewModel @Inject constructor(val repo: ConsoleRepo):ViewModel() {
    val AllUser = repo.userlist
    val AllProduct = repo.productlist
    val AllOrder = repo.orderlist
    init {
        viewModelScope.launch{
            repo.getAllUser()
            repo.getAllOrder()
            repo.getAllProduct()
        }
    }

    val id = mutableStateOf("")
    fun getId(idUser:String){
        Log.d("VMID","$idUser")
       id.value = idUser
    }
    val specificUserInfo: StateFlow<UserProfile?> = repo.specificUser
    fun specificUser(id :String){
        viewModelScope.launch {
            repo.specificUser(id)
        }
    }
    val specificOrder = repo.UserOrder
    fun  UserOrder(id:String){
        viewModelScope.launch {
            repo.userOrder(id)
        }
    }
}