package com.example.carstoragev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

const val MAP_CARS="cars.map"
class MapFragment : Fragment() , OnMapReadyCallback {
    private lateinit var storageCars: ArrayList<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val argsCars = requireArguments().getSerializable(MAP_CARS) as ArrayList<Car>
        storageCars = argsCars?:ArrayList()
        val supportMapFragment:SupportMapFragment=SupportMapFragment.newInstance()
        supportMapFragment.getMapAsync(this)
    }

    private lateinit var mapView: MapView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView= view.findViewById(R.id.mapView)
        if(mapView!=null){
            mapView.onCreate(null)
            mapView.onResume()
            mapView.getMapAsync(this)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        storageCars = requireArguments().getSerializable(MAP_CARS) as ArrayList<Car>
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(cars: ArrayList<Car>) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MAP_CARS, cars)
                }
            }
    }

    override fun onMapReady(p0: GoogleMap) {
        if (p0 != null) {
            for(i in storageCars.indices) {
                p0.addMarker(
                    MarkerOptions()
                        .position(LatLng(storageCars.get(i).latitude,storageCars.get(i).longitude))
                        .title(storageCars.get(i).name)
                        .snippet(storageCars.get(i).origin)
                )
            }
        }
    }


}