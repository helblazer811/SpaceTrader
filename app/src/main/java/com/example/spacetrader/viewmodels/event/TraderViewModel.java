package com.example.spacetrader.viewmodels.event;

import android.app.Application;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.tradegoods.Purchase;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * ViewModel of trader event
 */
public class TraderViewModel extends AndroidViewModel {


    private MutableLiveData<Player> player;
    private MutableLiveData<String> tradeString;
    private final PlayerRepository repository;
    private Purchase purchase;

    /**
     * Constructor that creates traderViewModel
     * @param application Android Application
     */
    public TraderViewModel(@NonNull Application application) {
        super(application);
        repository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes player into trader ViewModel
     * @param playerId id of the Player
     * @param owner owner of lifecycle of UI controllers
     */
    public void init(long playerId, LifecycleOwner owner) {
        LiveData<Player> loadPlayer = repository.getPlayer(playerId);
        tradeString = new MutableLiveData<>();
        player = new MutableLiveData<>();
        loadPlayer.observe(owner, new Observer<Player>() {
            /**
             * Inner class that calls when data is changed
             * @param p Player
             */
            @Override
            public void onChanged(Player p) {
                player.setValue(p);
                tradeString.setValue(initTradeMessage());
            }
        });
    }

    public String initTradeMessage() {
        int numCredits = (int) player.getValue().getCredits();
        int numPurchase = (int) (Math.random() * player.getValue().getAvailableInventorySpace() - 1) + 1;
        TradeGood good = TradeGood.values()[(int) (Math.random() * TradeGood.values().length)];
        String goodString = good.getStringRep();
        int purchasePrice =(int) (good.getBasePrice() / 2); //half the base price

        purchase = new Purchase(player.getValue().getAvailableInventorySpace(),
                    player.getValue().getCredits(),
                    player.getValue().getShip().getMaxFuel());
        purchase.getAmounts().put(good, numPurchase);
        purchase.getPrices().put(good, (double) purchasePrice);
        if (player.getValue().getCredits() < (purchasePrice * numPurchase)) {
            purchase.getAmounts().put(good, 0);
            purchase.getPrices().put(good, 0.0);
            return "You do not have enough to do buisness with this trader. He allows you to purchase peanuts." +
                    "Beacause that is what you are worth.";
        }

        return  "You have " + numCredits + " credits available to purchase "
                + numPurchase+ " " + goodString + " for " + (purchasePrice * numPurchase)+ " credits.";
    }

    /**
     * Fight trader in trader event
     */
    public void purchase() {

        player.getValue().applyPurchase(purchase);

        repository.insertPlayer(player.getValue());
    }

    /**
     * Getter for the purchase string
     * @return tradeString
     */
    public MutableLiveData<String> getTradeString() {
        return tradeString;
    }

    /**
     * Gets Player
     * @return Player
     */
    public MutableLiveData<Player> getPlayer() {
        return player;
    }

}
