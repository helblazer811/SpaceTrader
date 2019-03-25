package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.view.View;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Purchase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class InfoViewModel extends AndroidViewModel {


    private PlayerRepository playerRepository;

    private LiveData<Player> player;

    public InfoViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    public void init(long playerId, LifecycleOwner owner) {
        player = playerRepository.getPlayer(playerId);
    }

    public LiveData<Player> getPlayer() {
        return player;
    }


}
