package edu.temple.appsnmaps.foodocracy;

import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static final LatLng TempleU = new LatLng(39.9800884, -75.1576642);
    ImageButton ibtnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        setUpMapIfNeeded();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if (location!=null){
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            LatLng latLng = new LatLng(latitude, longitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        }else{
            mMap.moveCamera(CameraUpdateFactory.newLatLng(TempleU));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        }

        EditText mySearch = (EditText)findViewById(R.id.srcText);
        mySearch.setBackgroundColor(Color.parseColor("#ffffff"));
        ibtnGo = (ImageButton) findViewById(R.id.ibtnGo);
        ibtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MapsActivity.this
                        , ((EditText)findViewById(R.id.srcText)).getText().toString()
                        , Toast.LENGTH_LONG).show();

                Intent i = new Intent(MapsActivity.this, RewardStatus.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {


        Marker pizza = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(39.9820942, -75.1546786))
                .title("Petes")
                .snippet("Pizza")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_shipping_black_24dp)));

        Marker halal = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(39.9801511, -75.155345))
                .title("Buddy")
                .snippet("Halal")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_shipping_black_24dp)));

        Marker chinese = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(39.9800542, -75.1562311))
                .title("Chinese Food")
                .snippet("Chinese")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_shipping_black_24dp)));
    }
}
