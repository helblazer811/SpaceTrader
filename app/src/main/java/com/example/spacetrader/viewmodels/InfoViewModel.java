package com.example.spacetrader.viewmodels;

import android.app.Application;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

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
