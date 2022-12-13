package com.example.bottomnavigationsavingstate.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.SupportMapFragment;

public class ClientViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<SupportMapFragment> mapFragment = new MutableLiveData<>();

    public ClientViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setMapFragment(SupportMapFragment mapFragment){
        this.mapFragment.setValue(mapFragment);
    }

    public LiveData<SupportMapFragment> getMapFragment(){
        return mapFragment;
    }

    public SupportMapFragment getMapFragmentValue(){
        return mapFragment.getValue();
    }
}