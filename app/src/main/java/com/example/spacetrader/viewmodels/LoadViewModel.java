package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class LoadViewModel extends AndroidViewModel {
    /*This class is the load screen
        It will load a list of selectable saved instances of games
        on the local device from the room database. Firebase will be
        integrated later.
     */



    public LoadViewModel(@NonNull Application application) {
        super(application);
    }
}
