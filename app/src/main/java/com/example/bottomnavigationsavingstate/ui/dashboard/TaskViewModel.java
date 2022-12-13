package com.example.bottomnavigationsavingstate.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaskViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TaskViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("hello world");
    }

    public void setText() {
        mText.setValue("Dummy");
    }

    public LiveData<String> getText() {
        return mText;
    }
}