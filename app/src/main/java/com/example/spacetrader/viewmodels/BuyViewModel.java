package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Inventory;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Purchase;

public class BuyViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private View.OnFocusChangeListener onPurchaseFocus;

    private MutableLiveData<Purchase> purchase;

    private MutableLiveData<Player> player;
    private LiveData<Player> data;

    public BuyViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    public void init(long playerId, LifecycleOwner owner) {
        //initialize player object
        //encapsulation does not work by default
        //everything needs to be pulled from the database
        player = new MutableLiveData<Player>();
        purchase = new MutableLiveData<Purchase>();
        data = playerRepository.getPlayer(playerId);

        data.observe(owner, new Observer<Player>() {
            @Override
            public void onChanged(@Nullable Player data) {
                player.setValue(data);
                Purchase purchase_obj = new Purchase(data.getAvailableInventorySpace(), data.getCredits());
                purchase_obj.setMarketAvailability(data.getPlanet().getPlanetInventory());
                purchase_obj.setPrices(player.getValue().getPlanet().getPlanetPrices());
                purchase.setValue(purchase_obj);
            }
        });

        onPurchaseFocus = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    purchase.getValue().isValidPurchase();
                }
            }
        };
    }

    public MutableLiveData<Player> getPurchaseButtonClick() {
        return player;
    }

    public View.OnFocusChangeListener getPurchaseFocus() {
        return onPurchaseFocus;
    }

    public void onPurchaseButtonClick() {
        //click event
        if (purchase.getValue().isValidPurchase()) {
            player.getValue().applyPurchase(purchase.getValue());
            long value = playerRepository.insertPlayer(player.getValue());
        }
    }

    public MutableLiveData<Player> getPlayer() {
        return player;
    }

    public MutableLiveData<Purchase> getPurchase() {
        return purchase;
    }



}
