package com.example.spacetrader.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.spacetrader.dataaccess.DataAccessFacade;
import com.example.spacetrader.entities.initializers.GameInitializer;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Universe;

import java.util.Map;

public class PlayerConfigurationViewModel extends BaseObservable {

    private GameInitializer gameInitializer;
    private DataAccessFacade dataAccessFacade;

    public final ObservableField<Integer> pilotNumber = new ObservableField<>();
    public final ObservableField<Integer> fighterNumber = new ObservableField<>();
    public final ObservableField<Integer> engineerNumber = new ObservableField<>();
    public final ObservableField<Integer> traderNumber = new ObservableField<>();
    public final ObservableField<String> playerName = new ObservableField<>();

    public PlayerConfigurationViewModel() {
        gameInitializer = new GameInitializer();
        /*dataAccessFacade = DataAccessFacade.getInstance(
                getApplication().getApplicationContext());
        */
    }

    /*
        Handles the submission of the player configuration
     */
    public void onSubmit(Map<String, Object> configuration) throws Exception{
        //initialize the game objects
        //throws error if invalid configuration
        Player player = gameInitializer.initializePlayer(configuration);
        Universe universe = gameInitializer.initializeUniverse();

        //throw an error if the player is already in the database maybe
        dataAccessFacade.insertPlayer(player);

        //store in database
        //dataAccessFacade.insertGame();

    }

}
