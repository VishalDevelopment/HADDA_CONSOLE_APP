package com.example.haddamanagementconsole.DataLayer.Repo

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.haddamanagementconsole.DataLayer.Models.MyOrderResponse
import com.example.haddamanagementconsole.DataLayer.Models.ProductResponse
import com.example.haddamanagementconsole.DataLayer.Models.UserProfile
import com.example.haddamanagementconsole.DataLayer.Models.UsersItem
import com.example.haddamanagementconsole.DataLayer.Retrofit.ApiServices
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ConsoleRepo @Inject constructor(private val apiServices: ApiServices) {
    private val userListMutable = MutableStateFlow<List<UsersItem>>(emptyList())
    val userlist: StateFlow<List<UsersItem>>
        get() = userListMutable

    suspend fun getAllUser() {
        val response = apiServices.getAllUser()
        if (response.isSuccessful && response.body() != null) {
            Log.d("ALLUSER", response.body().toString())
            userListMutable.emit(response.body()!!)
        } else {
            Log.d("ALLUSER", response.body().toString())
        }
    }

    private val orderListMutable = MutableStateFlow<List<MyOrderResponse>>(emptyList())
    val orderlist: StateFlow<List<MyOrderResponse>>
        get() = orderListMutable

    suspend fun getAllOrder() {
        val response = apiServices.getAllOrder()
        if (response.isSuccessful && response.body() != null) {
            Log.d("ALLORDER", response.body().toString())
            orderListMutable.emit(response.body()!!)
        } else {
            Log.d("ALLORDER", response.body().toString())
        }
    }

    private val productListMutable = MutableStateFlow<List<ProductResponse>>(emptyList())
    val productlist: StateFlow<List<ProductResponse>>
        get() = productListMutable

    suspend fun getAllProduct() {
        val response = apiServices.getAllProduct()
        if (response.isSuccessful && response.body() != null) {
            Log.d("ALLPRODUCT", response.body().toString())
            productListMutable.emit(response.body()!!)
        } else {
            Log.d("ALLPRODUCT", response.body().toString())
        }
    }

    private val MutablespecificUser = MutableStateFlow<UserProfile?>(null)
    val specificUser: StateFlow<UserProfile?>
        get() = MutablespecificUser

    suspend fun specificUser(id: String) {
        val response = apiServices.getUserInfo(id)
        if (response.isSuccessful && response.body() != null) {
            Log.d("SPECIFICUSER", response.body().toString())
            MutablespecificUser.emit(response.body()!!)
        } else {

        }
    }

    private  val MutableUserOrder = MutableStateFlow<List<MyOrderResponse>>(emptyList())
    val UserOrder :MutableStateFlow<List<MyOrderResponse>>
        get() = MutableUserOrder

    suspend fun userOrder(id:String){
        val response = apiServices.getUserOrder(id)
        if (response.isSuccessful && response.body()!=null){
            Log.d("SpecificOrderRepo","${response.body()}")
            MutableUserOrder.emit(response.body()!!)
        }
        else{

        }
    }
    private  val MutableOrder = MutableStateFlow<MyOrderResponse?>(null)
    val OrderData :MutableStateFlow<MyOrderResponse?>
        get() = MutableOrder
    suspend fun OrderResponse(orderId:Int){
        val response = apiServices.SpecificOrder(orderId)
        if (response.isSuccessful && response.body()!=null){
            MutableOrder.emit(response.body()!!)
        }
        else{

        }
    }

}