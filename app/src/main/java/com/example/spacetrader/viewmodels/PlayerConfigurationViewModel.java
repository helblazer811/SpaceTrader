package com.example.spacetrader.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;

import com.example.spacetrader.dataaccess.DataAccessFacade;
import com.example.spacetrader.entities.initializers.GameInitializer;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Universe;

import java.util.Map;

public class PlayerConfigurationViewModel extends ViewModel {

    private GameInitializer gameInitializer;
    private DataAccessFacade dataAccessFacade;

    private Player player;

    private View.OnFocusChangeListener onFocusName;
    private View.OnFocusChangeListener onFocusPoint;
    private View.OnClickListener onClickSubmit;

    //Live data objects for the form data
    private MutableLiveData<Player> submitButtonClick = new MutableLiveData<>();

    public PlayerConfigurationViewModel() {
        super();
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

    /* init function

     */
    public void init() {
        player = new Player();
        onFocusName = new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    EditText et = (EditText) view;
                    //see if name already exists
                    //in the database for this user
                }
            }
        };

        onFocusPoint = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    EditText et = (EditText) view;
                    player.isValidConfiguration(true);
                }
            }
        };
    }

    public Player getPlayer() {
        return player;
    }

    public View.OnFocusChangeListener getPointOnFocusChangeListener() {
        return onFocusPoint;
    }

    public View.OnFocusChangeListener getNameOnFocusChangeListener() {
        return onFocusName;
    }

    public void onSubmitButtonClick(){
        if (player.isValid()) {
            submitButtonClick.setValue(player);
        }
    }

    public MutableLiveData<Player> getSubmitButtonClick() {
        return submitButtonClick;
    }

    @BindingAdapter("error")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }

    }
    @BindingAdapter("onFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }



}
