package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})
/**
 * ViewModel of Player Configuration
 */
public class PlayerConfigurationViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private Player player;

    private View.OnFocusChangeListener onFocusPoint;

    //Live data objects for the form data
    private MutableLiveData<Player> submitButtonClick = new MutableLiveData<>();

    /**
     * Constructor of PlayerConfiguration
     * @param application Android application
     */
    public PlayerConfigurationViewModel(@NonNull Application application) {
        super(application);
        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    /**
     * Initializes Player in PlayerConfigurationViewModel
     */
    public void init() {
        player = new Player();

        onFocusPoint = new View.OnFocusChangeListener() {
            /**
             * Called when the focus state of a view has changed.
             * @param view current view
             * @param focused if state is focused
             */
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    EditText et = (EditText) view;
                    player.isValidConfiguration(true);
                }
            }
        };

    }

    /**
     * Gets Player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets Point on Focus Change Listener
     * @return onFocusPoint
     */
    public View.OnFocusChangeListener getPointOnFocusChangeListener() {
        return onFocusPoint;
    }

    /**
     * Click on Submit Button
     */
    public void onSubmitButtonClick(){
        if (player.isValid()) {
            long value = playerRepository.insertPlayer(player);
            player.setPlayerId(value);
            submitButtonClick.setValue(player);
        }
    }

    /**
     * Gets Submit Button click
     * @return data from clicked submit button
     */
    public MutableLiveData<Player> getSubmitButtonClick() {
        return submitButtonClick;
    }

    /**
     * Sets error of ViewModel
     * @param editText Edit Text field
     * @param strOrResId Binding adapter
     */
    @BindingAdapter("error")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }
    }

    /**
     * Binds focus change
     * @param editText Edit Text Field
     * @param onFocusChangeListener focus change event
     */
    @BindingAdapter("onFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

}
