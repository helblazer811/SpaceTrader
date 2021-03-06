package com.example.spacetrader.viewmodels.load;

import android.app.Application;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * Load Screen of saved instances of Games
 */
public class LoadViewModel extends AndroidViewModel {
    /*This class is the load screen
        It will load a list of selectable saved instances of games
        on the local device from the room database. Firebase will be
        integrated later.
     */

    private final PlayerRepository playerRepository;
    private LiveData<List<Player>> players;

    /**
     * LoadView Model constructor
     * @param application Android application
     */
    public LoadViewModel(@NonNull Application application) {
        super(application);
        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes players in LoadViewModel
     * @param owner owner of lifecycle of UI controllers
     */
    public void init(LifecycleOwner owner) {
        players = playerRepository.getAllPlayers();

    }

    /**
     * Gets list of Players
     * @return list of Players
     */
    public LiveData<List<Player>> getPlayers() {
        return players;
    }

}
