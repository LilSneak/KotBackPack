package com.m1ctopt1.mytracker

import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng


class MapsMarkerActivity : AppCompatActivity(), OnMapReadyCallback {
    // onCreate method is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_main)


        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        val mapFragment: SupportMapFragment? =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        if (mapFragment != null) {
            mapFragment.getMapAsync(this)
        }
    }


    // This method is called when the map is ready to be used.
    override fun onMapReady(googleMap: GoogleMap) {

        try {
            var locationManager: LocationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            val locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (locationGPS != null) {
                val myPos: LatLng = LatLng(locationGPS.latitude, locationGPS.longitude)
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(myPos))
            } else {
                print("location not able to be found")
            }
        }catch(e: SecurityException){
            print(e.message)
        }
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.

    }
}