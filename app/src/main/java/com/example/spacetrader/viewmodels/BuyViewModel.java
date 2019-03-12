package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

public class BuyViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private View.OnFocusChangeListener onPurchaseFocus;

    private MutableLiveData<Player> player;
    private LiveData<Player> data;

    private MutableLiveData<Player> purchaseButtonClick = new MutableLiveData<>();

    public BuyViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    public void init(long playerId) {
        //initialize player object
        //encapsulation does not work by default
        //everything needs to be pulled from the database
        player = new MutableLiveData<Player>();
        data = playerRepository.getPlayer(playerId);
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

    public MutableLiveData<Player> getPlayer() {
        return player;
    }

    public LiveData<Player> getLiveData() {
        return data;
    }

}
