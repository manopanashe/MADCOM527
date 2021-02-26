package com.example.mappping


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.btn1)
        b1.setOnClickListener {
            val et1 = findViewById<EditText>(R.id.et1)
            val et2 = findViewById<EditText>(R.id.et2)
            val latitude = et1.getText().toString().toDouble()
            val longitude = et2.getText().toString().toDouble()
            val map1 = findViewById<MapView>(R.id.map1)
            map1.controller.setZoom(14.0)
            map1.controller.setCenter(GeoPoint(latitude, longitude))

        }

    }
}