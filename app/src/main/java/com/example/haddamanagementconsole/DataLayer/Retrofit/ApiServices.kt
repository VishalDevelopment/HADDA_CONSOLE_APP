package com.example.haddamanagementconsole.DataLayer.Retrofit

import com.example.haddamanagementconsole.DataLayer.Models.MyOrderResponse
import com.example.haddamanagementconsole.DataLayer.Models.ProductResponse
import com.example.haddamanagementconsole.DataLayer.Models.UserProfile
import com.example.haddamanagementconsole.DataLayer.Models.UsersItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
interface ApiServices {

    @FormUrlEncoded
    @POST("/SpecificOrder")
    suspend fun SpecificOrder(@Field("orderId") orderId :Int):Response<MyOrderResponse?>

    @FormUrlEncoded
    @POST("/orders")
    suspend fun MyOrder(@Field("user_id") id:String): Response<List<MyOrderResponse>>
    @FormUrlEncoded
    @POST("/GetUser")
    suspend fun getUserInfo(@Field("userId") UserID: String): Response<UserProfile?>
    @FormUrlEncoded
    @POST ("/orders")
    suspend fun getUserOrder(@Field("user_id")UserID: String):Response<List<MyOrderResponse>>

    @GET("/AllUser")
    suspend fun getAllUser():Response<List<UsersItem>>
    @GET("/getAllOrder")
    suspend fun getAllOrder():Response<List<MyOrderResponse>>
    @GET("/getAllProduct")
    suspend fun getAllProduct():Response<List<ProductResponse>>

}
