package net.hellobye.gohajj;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;


    Intent intent = getIntent();
    String  laa = "";
    String  loo = "";
    String  name = "";
    String  dis = " ";
    String  Stat = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        laa = getIntent().getStringExtra("lan");
        loo = getIntent().getStringExtra("long");

        name = getIntent().getStringExtra("name");
        dis = getIntent().getStringExtra("dis");
        Stat = getIntent().getStringExtra("status");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double lan1 = Double.parseDouble(laa);
        Double LONG1 = Double.parseDouble(loo);
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(lan1, LONG1);



        mMap.addMarker(new MarkerOptions().position(sydney).title( name + dis  + " | " + Stat));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10.0f));



    }
}
