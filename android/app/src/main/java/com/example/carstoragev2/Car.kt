package com.example.carstoragev2

import java.io.Serializable

data class Car(val name: String,
               val mpg: Int,
               val nbCylinders: Int,
               val displacement:Int,
               val horsepower:Int,
               val weight:Int,
               val acceleration:Double,
               val model :Int,
               val origin:String,
               val latitude: Double,
               val longitude: Double): Serializable {}