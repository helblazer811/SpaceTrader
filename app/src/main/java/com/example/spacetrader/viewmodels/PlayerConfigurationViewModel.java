package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetrader.dataaccess.DataAccessFacade;
import com.example.spacetrader.dataaccess.GameInitializer;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Universe;

import java.util.Map;

public class PlayerConfigurationViewModel extends AndroidViewModel {

    private GameInitializer gameInitializer;
    private DataAccessFacade dataAccessFacade =
            DataAccessFacade.getInstance(getApplication().getApplicationContext());

    public PlayerConfigurationViewModel(@NonNull Application application) {
        super(application);
        gameInitializer = new GameInitializer();
    }

    /*
        Handles the submission of the player configuration
     */
    public void onSubmit(Map<String, Object> configuration) throws Exception{
        //initialize the game objects
        Player player = gameInitializer.initializePlayer(configuration);
        Universe universe = gameInitializer.initializeUniverse();

        dataAccessFacade.insertPlayer(player);

        //store in database
        //dataAccessFacade.insertGame();

    }

}
