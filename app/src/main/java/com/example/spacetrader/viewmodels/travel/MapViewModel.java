package com.example.spacetrader.viewmodels.travel;

import android.app.Application;
import android.view.View;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.planet.Planet;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MapViewModel extends AndroidViewModel {

    /*This class is the load screen
        It will load a list of selectable saved instances of games
        on the local device from the room database. Firebase will be
        integrated later.
     */

    private PlayerRepository playerRepository;
    private LiveData<Player> player;
    private MutableLiveData<List<Planet>> travelablePlanets;

    public MapViewModel(@NonNull Application application) {
        super(application);
        playerRepository = new PlayerRepository(application.getApplicationContext());
        travelablePlanets = new MutableLiveData<>();
    }

    public void init(long playerId, LifecycleOwner owner) {
        player = playerRepository.getPlayer(playerId);

        player.observe(owner, new Observer<Player>() {
            @Override
            public void onChanged(Player player) {
                //set travelable planets
                travelablePlanets.setValue(player.getPlanetsWithinRange());
            }
        });
    }


    public LiveData<Player> getPlayer() {
        return player;
    }

    public void setPlayer(LiveData<Player> player) {
        this.player = player;
    }

    public MutableLiveData<List<Planet>> getTravelablePlanets() {
        return travelablePlanets;
    }

    public void setTravelablePlanets(MutableLiveData<List<Planet>> travelablePlanets) {
        this.travelablePlanets = travelablePlanets;
    }


    public void insertPlayer(Player player) {
        playerRepository.insertPlayer(player);
    }
}
