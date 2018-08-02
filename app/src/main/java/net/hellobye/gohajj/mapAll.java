package net.hellobye.gohajj;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapAll  extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_all);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng sydney = new LatLng(21.4385, 39.1980);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Akarm | (bpm: 78 , T:40C , W:Not Good)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap = googleMap;
        LatLng bro = new LatLng(21.4485, 39.2990);
        mMap.addMarker(new MarkerOptions().position(bro).title("Mohammed Samy | (bpm: 78, T:33C , W:oK)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bro));

        mMap = googleMap;
        LatLng bro1 = new LatLng(21.4585, 39.3180);
        mMap.addMarker(new MarkerOptions().position(bro1).title("Mohammed Araby | (bpm: 68 , T:31C , W:oK)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bro1));

        mMap = googleMap;
        LatLng bro2 = new LatLng(21.4685, 39.2390);
        mMap.addMarker(new MarkerOptions().position(bro2).title("Mohammed Khames | (bpm: 78 , T:32C , W:oK)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bro2));

        mMap = googleMap;
        LatLng bro3 = new LatLng(21.4685, 39.2490);
        mMap.addMarker(new MarkerOptions().position(bro3).title("Amr elborolsy | (bpm: 180 , T:32C , W:Danger)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bro3));


        mMap.animateCamera(CameraUpdateFactory.zoomTo(11.2f));






    }
}
