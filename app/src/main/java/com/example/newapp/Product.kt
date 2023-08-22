package com.example.newapp

import com.google.gson.annotations.SerializedName


data class Product(
    val products:List<Result>)
data class Result(
    var title :String,
    var price:Double,
    var description:String,
    var stock:Int,
    var brand:String,
    var category:String,
    @SerializedName("thumbnail") var image:String

)
