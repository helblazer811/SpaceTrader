package com.example.spacetrader.viewmodels.event;

import android.app.Application;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.event.Enemy;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class PirateViewModel extends AndroidViewModel {

    private MutableLiveData<Player> player;
    private PlayerRepository repository;

    public PirateViewModel(@NonNull Application application) {
        super(application);
        repository = new PlayerRepository(application.getApplicationContext());
    }

    public void init(long playerId, LifecycleOwner owner) {
        LiveData<Player> loadPlayer = repository.getPlayer(playerId);
        player = new MutableLiveData<>();

        loadPlayer.observe(owner, new Observer<Player>() {
            @Override
            public void onChanged(Player p) {
                player.setValue(p);
            }
        });
    }

    public void fight() {
        //subtract health from pirate
        player.getValue().getEnemy().setCurrentHealth(10);
        player.getValue().getShip().setShipHealth(20);
/*

        pirate.getValue().takeDamage(20);//starts off as 20 damage by default
        //if not dead
        if (pirate.getValue().isAlive()) {
            //subtract health from player
            player.getValue().getShip().takeDamage(10);//10 damage default
        }
*/

        repository.insertPlayer(player.getValue());
    }

    public boolean playerIsAlive() {
        return player.getValue().isAlive();
    }

    public boolean enemyIsAlive() {
        return player.getValue().getEnemy().isAlive();
    }

    public void emptyPlayerInventory() {
        player.getValue().emptyInventory();
    }

    public void setPlayerHealthHalf() {
        player.getValue().setPlayerHealthHalf();
    }

    public MutableLiveData<Player> getPlayer() {
        return player;
    }
}
