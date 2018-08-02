package net.hellobye.gohajj;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton bt = findViewById(R.id.floatingActionButton2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, mapAll.class);
                startActivity(i);
            }
        });






        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();

        androidFlavors.add(new AndroidFlavor("Akram Zeyada", " 100 m", R.mipmap.akarm,21.4385, 39.1873, "| (bpm: 78, T:33C , W:oK)"));
        androidFlavors.add(new AndroidFlavor("Mohammed Araby", " 500 m", R.mipmap.araby,21.4585,39.3180,"| (bpm: 78, T:33C , W:oK)"));
        androidFlavors.add(new AndroidFlavor("Mohammed Samy", " 400 m", R.mipmap.samy,21.4585,39.3180,"(bpm: 68 , T:31C , W:oK)"));
        androidFlavors.add(new AndroidFlavor("Amr Elbrolosy", " 300 m", R.mipmap.amr,21.4685,39.2390,"(bpm: 78 , T:32C , W:oK)"));
        androidFlavors.add(new AndroidFlavor("Mohammed khames", " 200 m", R.mipmap.khames,21.4685,39.2490,"(bpm: 180 , T:32C , W:Danger)"));



        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        net.hellobye.gohajj.AndroidFlavorAdapter flavorAdapter = new net.hellobye.gohajj.AndroidFlavorAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);


        // Add Click Listener to play word
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                AndroidFlavor word = androidFlavors.get(position);

              String name =  word.getVersionName();
              String dis = word.getVersionNumber();
                String lat1 = String.valueOf(word.mlat1());
              String lon1 = String.valueOf(word.long1());
              String status = word.status2();



                Intent intent = new Intent(MainActivity.this, Maps.class);
                intent.putExtra("lan", lat1);
                intent.putExtra("long", lon1);
                intent.putExtra("name", name);
                intent.putExtra("dis", dis);
                intent.putExtra("status", status);
                startActivity(intent);

            }
        });


    }





}
