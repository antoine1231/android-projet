package com.example.carstoragev2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {


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

    private val cars= arrayListOf<Car>(Chevrolet,Plymouth,Buick,Citroen,Peugeot)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemName: TextView
        var itemOrigin: TextView
        var itemModel: TextView

        var itemCylinder:Int = 0
        var itemDisplacement:Int=0
        var itemHorsepower:Int=0
        var itemWeight:Int=0
        var itemMpg:Int=0
        var itemAcceleration:Double=0.0


        init {
            itemName = itemView.findViewById(R.id.name)
            itemOrigin = itemView.findViewById(R.id.origin)
            itemModel = itemView.findViewById(R.id.model)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                //the aim below is to transmit the data to the details fragment in order to display everything
                val intent = Intent(context, DetailsActivity::class.java).apply {
                   putExtra("NUMBER", position)
                    putExtra("NAME", itemName.text)
                    putExtra("ORIGIN", itemOrigin.text)
                    putExtra("MODEL", itemModel.text)
                    putExtra("CYLINDER", itemCylinder)
                    putExtra("DISPLACEMENT", itemDisplacement)
                    putExtra("HORSEPOWER", itemHorsepower)
                    putExtra("WEIGHT", itemWeight)
                    putExtra("ACCELERATION", itemAcceleration)
                    putExtra("MPG", itemMpg)
                   // putExtra("CARS",cars) to improve the code we should replace all the data by passing th cars list instead
                }
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = cars[i].name
        viewHolder.itemOrigin.text = cars[i].origin
        viewHolder.itemModel.text = cars[i].model.toString()
        viewHolder.itemCylinder=cars[i].nbCylinders
        viewHolder.itemDisplacement=cars[i].displacement
        viewHolder.itemHorsepower=cars[i].horsepower
        viewHolder.itemWeight=cars[i].weight
        viewHolder.itemAcceleration=cars[i].acceleration
        viewHolder.itemMpg=cars[i].mpg


    }

    override fun getItemCount(): Int {
        return cars.size
    }
}