package com.yazlab.mobilsorgular;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SonucTip3 extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private String TAG = "so47492459";
    String location1="istanbul";
    String location2="ankara";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle gelenVeri=getIntent().getExtras();

         location1 = gelenVeri.getCharSequence("location1").toString();
        location2 = gelenVeri.getCharSequence("location2").toString();

        setContentView(R.layout.activity_sonuc_tip3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(Geocoder.isPresent()){
            try {

                Geocoder gc = new Geocoder(this);
                List<Address> addresses= gc.getFromLocationName(location1, 5);
                List<Address> addresses2= gc.getFromLocationName(location2, 5);
                List<LatLng> ll = new ArrayList<LatLng>(addresses.size());
                List<LatLng> ll2 = new ArrayList<LatLng>(addresses2.size());
                for(Address a : addresses){
                    if(a.hasLatitude() && a.hasLongitude()){
                        ll.add(new LatLng(a.getLatitude(), a.getLongitude()));
                    }
                }
                for(Address a : addresses2){
                    if(a.hasLatitude() && a.hasLongitude()){
                        ll2.add(new LatLng(a.getLatitude(), a.getLongitude()));
                    }
                }
                mMap.addMarker(new MarkerOptions().position(ll.get(0)).title(location1));

                LatLng madrid = new LatLng(40.416775,-3.70379);
                mMap.addMarker(new MarkerOptions().position(ll2.get(0)).title(location2));
                double lokasyon1lat=ll.get(0).latitude;
                double lokasyon1long=ll.get(0).longitude;
                double lokasyon2lat=ll2.get(0).latitude;
                double lokasyon2long=ll2.get(0).longitude;
                String lokasyon1=""+lokasyon1lat+lokasyon1long;
                String lokasyon2=""+lokasyon2lat+lokasyon2long;



                List<LatLng> path = new ArrayList();



                GeoApiContext context = new GeoApiContext.Builder()
                        .apiKey("AIzaSyAANhM8tNl1Qx72nq5OMMOGlFELzNqGShI")
                        .build();
                DirectionsApiRequest req = DirectionsApi.getDirections(context, ""+lokasyon1, ""+lokasyon2);
                try {
                    DirectionsResult res = req.await();


                    if (res.routes != null && res.routes.length > 0) {
                        DirectionsRoute route = res.routes[0];

                        if (route.legs !=null) {
                            for(int i=0; i<route.legs.length; i++) {
                                DirectionsLeg leg = route.legs[i];
                                if (leg.steps != null) {
                                    for (int j=0; j<leg.steps.length;j++){
                                        DirectionsStep step = leg.steps[j];
                                        if (step.steps != null && step.steps.length >0) {
                                            for (int k=0; k<step.steps.length;k++){
                                                DirectionsStep step1 = step.steps[k];
                                                EncodedPolyline points1 = step1.polyline;
                                                if (points1 != null) {

                                                    List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
                                                    for (com.google.maps.model.LatLng coord1 : coords1) {
                                                        path.add(new LatLng(coord1.lat, coord1.lng));
                                                    }
                                                }
                                            }
                                        } else {
                                            EncodedPolyline points = step.polyline;
                                            if (points != null) {

                                                List<com.google.maps.model.LatLng> coords = points.decodePath();
                                                for (com.google.maps.model.LatLng coord : coords) {
                                                    path.add(new LatLng(coord.lat, coord.lng));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch(Exception ex) {
                    Log.e(TAG, ex.getLocalizedMessage());
                }


                if (path.size() > 0) {
                    PolylineOptions opts = new PolylineOptions().addAll(path).color(Color.BLUE).width(5);
                    mMap.addPolyline(opts);
                }

                mMap.getUiSettings().setZoomControlsEnabled(true);

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll.get(0), 10));











            } catch (IOException e) {

            }











        }



    }
}
