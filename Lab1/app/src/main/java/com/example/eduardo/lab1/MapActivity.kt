package com.example.eduardo.lab1

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private val LOCATION_PERMS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
private val UANDES_LOCATION = LatLng(-33.403788, -70.506888)
private val INITIAL_ZOOM = 17F

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        requestPermissions(LOCATION_PERMS, 1340)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(checkSelfPermission(permissions[0]) == PackageManager.PERMISSION_GRANTED)
        {
            val mapFragment = supportFragmentManager
                    .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.isMyLocationEnabled = true

        googleMap.addMarker(MarkerOptions().position(UANDES_LOCATION)
                .title("UANDES"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(UANDES_LOCATION))
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(INITIAL_ZOOM))
    }
}
