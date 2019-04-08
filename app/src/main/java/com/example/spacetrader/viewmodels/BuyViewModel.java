package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.view.View;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.tradegoods.Purchase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * ViewModel of Buying in-game
 */
public class BuyViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private View.OnFocusChangeListener onPurchaseFocus;

    private MutableLiveData<Purchase> purchase;

    private MutableLiveData<Player> player;
    private LiveData<Player> data;

    /**
     * Constructor for BuyViewModel
     * @param application Android application
     */
    public BuyViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes Player in the BuyViewModel
     * @param playerId id of Player
     * @param owner owner of lifecycle of UI controllers
     */
    public void init(long playerId, LifecycleOwner owner) {
        //initialize player object
        //encapsulation does not work by default
        //everything needs to be pulled from the database
        player = new MutableLiveData<Player>();
        purchase = new MutableLiveData<Purchase>();
        data = playerRepository.getPlayer(playerId);

        data.observe(owner, new Observer<Player>() {
            /**
             * Called when data is changed
             * @param data Player data
             */
            @Override
            public void onChanged(@Nullable Player data) {
                player.setValue(data);
                Purchase purchase_obj = new Purchase(data.getAvailableInventorySpace(), data.getCredits()
                        , data.getShip().getMaxFuel() - data.getShip().getFuel());
                purchase_obj.setMarketAvailability(data.getPlanet().getPlanetInventory());
                purchase_obj.setPrices(player.getValue().getPlanet().getPlanetPrices());
                purchase.setValue(purchase_obj);
            }
        });

        onPurchaseFocus = new View.OnFocusChangeListener() {
            /**
             * Called when the focus state of a view has changed.
             * @param view current View
             * @param focused if state is focused or not
             */
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    purchase.getValue().isValidPurchase();
                }
            }
        };
    }

    /**
     * Gets Purchase Button Click
     * @return player
     */
    public MutableLiveData<Player> getPurchaseButtonClick() {
        return player;
    }

    /**
     * Gets Purchase Focus
     * @return onPurchaseFocus state
     */
    public View.OnFocusChangeListener getPurchaseFocus() {
        return onPurchaseFocus;
    }

    /**
     * Clicks buy event
     */
    public void onPurchaseButtonClick() {
        //click event
        if (purchase.getValue().isValidPurchase()) {
            player.getValue().applyPurchase(purchase.getValue());
            long value = playerRepository.insertPlayer(player.getValue());
        }
    }

    /**
     * Gets player data
     * @return player
     */
    public MutableLiveData<Player> getPlayer() {
        return player;
    }

    /**
     * Gets purchase data
     * @return purchase
     */
    public MutableLiveData<Purchase> getPurchase() {
        return purchase;
    }



}
