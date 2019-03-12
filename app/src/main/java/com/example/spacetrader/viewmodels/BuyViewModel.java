package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

public class BuyViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private View.OnFocusChangeListener onPurchaseFocus;

    private LiveData<Player> player;

    private MutableLiveData<Player> purchaseButtonClick = new MutableLiveData<>();

    public BuyViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    public void init(String playerId) {
        //initialize player object
        //encapsulation does not work by default
        //everything needs to be pulled from the database
        player = playerRepository.getPlayer(playerId);
        onPurchaseFocus = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    player.getValue().isValidConfiguration(true);
                }
            }
        };
    }

    public MutableLiveData<Player> getPurchaseButtonClick() {
        return purchaseButtonClick;
    }

    public View.OnFocusChangeListener getPurchaseFocus() {
        return onPurchaseFocus;
    }

    public void onPurchaseButtonClick() {
        //click event

    }

}
