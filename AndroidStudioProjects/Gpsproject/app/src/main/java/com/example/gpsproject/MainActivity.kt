package com.example.gpsproject

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity(), LocationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.btn1)
        b1.setOnClickListener{
            val et1 = findViewById<EditText>(R.id.et1)
            val et2 = findViewById<EditText>(R.id.et2)
            val latitude = et1.getText().toString().toDouble()
            val longitude = et2.getText().toString().toDouble()
            val map1 = findViewById<MapView>(R.id.map1)
            map1.controller.setZoom(14.0)
            map1.controller.setCenter(GeoPoint(latitude, longitude))

        }

        requestGps()

    }
    fun requestGps(){
        //check wether the ACCESS_FINE_LOCATION permission has been granted
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //setup our location listener to start listineng for gps updates
            val mgr=getSystemService(Context.LOCATION_SERVICE) as LocationManager

            mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,0f, this)
        }


        else{
            ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),0)
            //requesr permisiion
        }
    }
    override fun onLocationChanged(newLoc: Location) {
        Toast.makeText (this, "Latitude=${newLoc.latitude},Longitude${newLoc.longitude}", Toast.LENGTH_LONG).show()
    }

    override fun onProviderDisabled(provider: String) {
        Toast.makeText (this, "Provider disabled", Toast.LENGTH_LONG).show()
    }

    override fun onProviderEnabled(provider: String) {
        Toast.makeText (this, "Provider enabled", Toast.LENGTH_LONG).show()
    }
//methods which runs when the user has either granted or denied permisiion
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode)
      { 0->{
        if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            requestGps()

        }else{
            AlertDialog.Builder(this)
                    .setPositiveButton("ok",null)
                    .setMessage("we cannot access your location")
                    .show()
        }
        }

        }

    //if the ACCESS_FINE_LOCATION permission has been granted the
    //call requestGps() again
    //this time the permission will be granted so we can start listening for Gps updates
    }

}