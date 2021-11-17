package com.example.carstoragev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(){
    //data in order to test the application before the connection with the API
    private val Chevrolet=Car(
        name="Chevrolet Chevelle Malibu",
        mpg=18,
        nbCylinders=8,
        displacement=307,
        horsepower = 130,
        weight = 3504,
        acceleration=12.0,
        model=70,
        origin = "US",
        latitude = 44.5,
        longitude=-89.5)


    private val Plymouth=Car(
        name="Plymouth Satellite",
        mpg=18,
        nbCylinders=8,
        displacement=318,
        horsepower = 150,
        weight = 3436,
        acceleration=11.0,
        model=70,
        origin = "US",
        latitude = 44.0,
        longitude=-72.699997)

    private val Buick=Car(
        name="Buick Skylark 320",
        mpg=15,
        nbCylinders=8,
        displacement=350,
        horsepower = 165,
        weight = 3693,
        acceleration=11.5,
        model=70,
        origin = "US",
        latitude = 39.0,
        longitude=-80.5)

    private val Citroen=Car(
        name="Citroen DS-21 Pallas",
        mpg=0,
        nbCylinders=4,
        displacement=133,
        horsepower = 115,
        weight = 3090,
        acceleration=17.5,
        model=70,
        origin = "Europe",
        latitude = 45.8,
        longitude=4.8)

    private val Peugeot=Car(
        name="Peugeot 504",
        mpg=25,
        nbCylinders=4,
        displacement=110,
        horsepower = 87,
        weight = 2672,
        acceleration=17.5,
        model=70,
        origin = "Europe",
        latitude = 48.8,
        longitude=2.4)

    private val storageCars = StorageCars()

/*function in order to get data from the API : not fully implemented
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://Project_MDR-AMO.cleverapps.io/")
        .build()
    val carService = retrofit.create(CarService::class.java)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storageCars.addCar(Plymouth)
        storageCars.addCar(Buick)
        storageCars.addCar(Chevrolet)
        storageCars.addCar(Citroen)
        storageCars.addCar(Peugeot)


        val btnMap = findViewById<Button>(R.id.button_map)
        btnMap.setOnClickListener { view: View? ->
            displayMap()
        }

        val btnList = findViewById<Button>(R.id.button_list)
        btnList.setOnClickListener { view: View? ->
            displayList()
        }

        val btnInfo = findViewById<Button>(R.id.button_info)
        btnInfo.setOnClickListener { view: View? ->
            displayInfo()
        }
        //displaying list fragment on launching
        displayList()
    }
//functions to display all the fragment in the view container
    private fun displayMap() {
        val fragment=MapFragment.newInstance(storageCars.getAllCars())
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.view_list, fragment)
        fragmentTransaction.addToBackStack("tag")
        fragmentTransaction.commit()
    }

     private fun displayList() {
         val fragmentTransaction = supportFragmentManager.beginTransaction()
         val fragment = ListFragment()
         fragmentTransaction.replace(R.id.view_list, fragment)
         fragmentTransaction.commit()
     }

    private fun displayInfo() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = InfoFragment()
        fragmentTransaction.replace(R.id.view_list, fragment)
        fragmentTransaction.commit()
    }
}


