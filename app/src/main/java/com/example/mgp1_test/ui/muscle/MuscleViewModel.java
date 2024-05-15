package com.example.mgp1_test.ui.muscle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MuscleViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MuscleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}