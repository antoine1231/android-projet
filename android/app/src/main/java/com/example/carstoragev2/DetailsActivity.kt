package com.example.carstoragev2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //get data from the other activity
        val number = intent.getSerializableExtra("NUMBER")
        val name = intent.getSerializableExtra("NAME")
        val origin = intent.getSerializableExtra("ORIGIN")
        val model = intent.getSerializableExtra("MODEL")
        val cylinder = intent.getSerializableExtra("CYLINDER")
        val displacement = intent.getSerializableExtra("DISPLACEMENT")
        val horsepower = intent.getSerializableExtra("HORSEPOWER")
        val weight = intent.getSerializableExtra("WEIGHT")
        val mpg = intent.getSerializableExtra("MPG")
        val acceleration = intent.getSerializableExtra("ACCELERATION")


        //link the data with the corresponding textview
        val textViewName = findViewById<View>(R.id.detail_name) as TextView
        val textViewOrigin=findViewById<View>(R.id.detail_origin) as TextView
        val textViewModel=findViewById<View>(R.id.detail_model) as TextView
        val textViewCylinder=findViewById<View>(R.id.detail_cylinder) as TextView
        val textViewDisplacement=findViewById<View>(R.id.detail_displacement) as TextView
        val textViewHorsepower=findViewById<View>(R.id.detail_horsepower) as TextView
        val textViewWeight=findViewById<View>(R.id.detail_weight) as TextView
        val textViewMpg=findViewById<View>(R.id.detail_mpg) as TextView
        val textViewAcceleration=findViewById<View>(R.id.detail_acceleration) as TextView


        //displaying the text of textview
        textViewName.text=name.toString()
        textViewCylinder.text = cylinder.toString()
        textViewOrigin.text = origin.toString()
        textViewModel.text = model.toString()
        textViewDisplacement.text = displacement.toString()
        textViewHorsepower.text = horsepower.toString()
        textViewWeight.text = weight.toString()
        textViewMpg.text = mpg.toString()
        textViewAcceleration.text = acceleration.toString()


        val btnBack = findViewById<Button>(R.id.button_back)
        btnBack.setOnClickListener { view: View? ->
            super.onBackPressed()
        }
    }
}