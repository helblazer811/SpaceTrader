package com.example.spacetrader.viewmodels.event;

import android.app.Application;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * ViewModel of Police event
 */
public class PoliceViewModel extends AndroidViewModel {


    private MutableLiveData<Player> player;
    private final PlayerRepository repository;
    private boolean fightStarted = false;

    /**
     * Constructor that creates PoliceViewModel
     * @param application Android Application
     */
    public PoliceViewModel(@NonNull Application application) {
        super(application);
        repository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes player into Police ViewModel
     * @param playerId id of the Player
     * @param owner owner of lifecycle of UI controllers
     */
    public void init(long playerId, LifecycleOwner owner) {
        LiveData<Player> loadPlayer = repository.getPlayer(playerId);
        player = new MutableLiveData<>();

        loadPlayer.observe(owner, new Observer<Player>() {
            /**
             * Inner class that calls when data is changed
             * @param p Player
             */
            @Override
            public void onChanged(Player p) {
                if (!fightStarted)
                    p.getEnemy().resetHealth();

                fightStarted = true;
                //rest enemy
                player.setValue(p);
            }
        });
    }

    /**
     * Fight Police in Police event
     */
    public void fight() {
        //subtract health from police
        //player.getValue().getEnemy().setCurrentHealth(10);
        player.getValue().getEnemy().doDamage(20);//starts off as 20 damage by default
        //if not dead
        if (player.getValue().getEnemy().isAlive()) {
            //subtract health from player
            player.getValue().getShip().takeDamage(10);//10 damage default
        }

        repository.insertPlayer(player.getValue());
    }

    /**
     * Tells if enemy is alive
     * @return if enemy is alive
     */
    public boolean enemyIsAlive() {
        return player.getValue().getEnemy().isAlive();
    }

    /**
     * Tells if player is alive
     * @return if player is alive
     */
    public boolean playerIsAlive() {
        return player.getValue().isAlive();
    }

    /**
     * Empties Player Inventory
     */
    public void emptyPlayerInventory() {
        player.getValue().emptyInventory();
    }

    /**
     * Sets Player Health to half
     */
    public void setPlayerHealthHalf() {
        player.getValue().setPlayerHealthHalf();
    }

    /**
     * Gets Player
     * @return Player
     */
    public MutableLiveData<Player> getPlayer() {
        return player;
    }
}
