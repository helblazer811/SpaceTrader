package com.example.spacetrader.viewmodels;

import android.app.Application;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

/**
 * ViewModel of Information
 */
public class InfoViewModel extends AndroidViewModel {


    private final PlayerRepository playerRepository;

    private LiveData<Player> player;

    /**
     * Constructor that creates InfoViewModel
     * @param application Android application
     */
    public InfoViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes Player in the InfoViewModel
     * @param playerId id of Player
     * @param owner owner of lifecycle of UI controllers
     */
    public void init(long playerId, LifecycleOwner owner) {
        player = playerRepository.getPlayer(playerId);
    }

    /**
     * Gets Player data
     * @return player
     */
    public LiveData<Player> getPlayer() {
        return player;
    }


}
