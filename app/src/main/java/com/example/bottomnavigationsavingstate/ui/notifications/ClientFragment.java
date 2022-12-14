package com.example.bottomnavigationsavingstate.ui.notifications;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigationsavingstate.R;
import com.example.bottomnavigationsavingstate.databinding.FragmentNotificationsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ClientFragment extends Fragment implements OnMapReadyCallback {

    private FragmentNotificationsBinding binding;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private static final String TAG = "ClientFragment";
    ClientViewModel clientViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientViewModel =
                new ViewModelProvider(this).get(ClientViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
//        clientViewModel.getMapFragment().observe(getViewLifecycleOwner(),it->{
//            mapFragment = it;
//            Log.i(TAG,"getMap -> "+mapFragment);
//        });

        Log.i(TAG,"map fragment value -> "+clientViewModel.getMapFragmentValue());

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

//        if (mapFragment == null) {
//            mapFragment = SupportMapFragment.newInstance();
//            mapFragment.getMapAsync(this);
//            getChildFragmentManager().beginTransaction().replace(R.id.client_dashboardMap, mapFragment).commit();
//            clientViewModel.setMapFragment(mapFragment);
//            Log.i(TAG,"setMap -> "+mapFragment);
//        }

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.client_dashboardMap);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        GoogleMapOptions googleMapOptions = new GoogleMapOptions().liteMode(true);
        mMap = googleMap;
        mMap.setMapType(googleMapOptions.getMapType());

        // Add a marker in cyber hub and move the camera
        LatLng sydney = new LatLng(28.4622138,77.1004585);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Cyber hub"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14f));
    }
}