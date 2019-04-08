package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.view.View;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.tradegoods.Sale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * ViewModel of Selling in-game
 */
public class SellViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private View.OnFocusChangeListener onSaleFocus;

    private MutableLiveData<Sale> sale;

    private MutableLiveData<Player> player;
    private LiveData<Player> data;

    /**
     * Constructor that creates SellViewModel
     * @param application Android Application
     */
    public SellViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes Player object in SellViewModel
     * @param playerId id of Player
     * @param owner owner of lifecycle of UI controllers
     */
    public void init(long playerId, LifecycleOwner owner) {
        //initialize player object
        //encapsulation does not work by default
        //everything needs to be pulled from the database
        player = new MutableLiveData<Player>();
        sale = new MutableLiveData<Sale>();
        data = playerRepository.getPlayer(playerId);

        data.observe(owner, new Observer<Player>() {
            /**
             * Called when the data is changed.
             * @param data Player data
             */
            @Override
            public void onChanged(@Nullable Player data) {
                player.setValue(data);
                Sale sale_obj = new Sale();
                sale_obj.setPlayerAmounts(player.getValue().getInventory().getInventoryMap());
                sale_obj.setPrices(player.getValue().getPlanet().getPlanetPrices());
                sale.setValue(sale_obj);
            }
        });

        onSaleFocus = new View.OnFocusChangeListener() {

            /**
             * Called when the focus state of a view has changed.
             *
             * @param view view whose state has changed
             * @param focused if the state is focused
             */
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    sale.getValue().isValidSale();
                }
            }
        };
    }

    /**
     * Gets Sale Button Click data
     * @return player data
     */
    public MutableLiveData<Player> getSaleButtonClick() {
        return player;
    }

    /**
     * Gets Sale Focus data
     * @return onSaleFocus data
     */
    public View.OnFocusChangeListener getSaleFocus() {
        return onSaleFocus;
    }

    /**
     * Click Sale Button
     */
    public void onSaleButtonClick() {
        //click event
        if (sale.getValue().isValidSale()) {
            player.getValue().applySale(sale.getValue());
            long value = playerRepository.insertPlayer(player.getValue());
        }
    }

    /**
     * Gets Player data
     * @return player
     */
    public MutableLiveData<Player> getPlayer() {
        return player;
    }

    /**
     * Gets Sale data
     * @return sale
     */
    public MutableLiveData<Sale> getSale() {
        return sale;
    }



}
