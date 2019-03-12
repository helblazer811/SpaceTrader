package com.example.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.entities.Player;

@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})
public class PlayerConfigurationViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;

    private Player player;

    private View.OnFocusChangeListener onFocusPoint;

    //Live data objects for the form data
    private MutableLiveData<Player> submitButtonClick = new MutableLiveData<>();

    public PlayerConfigurationViewModel(@NonNull Application application) {
        super(application);
        playerRepository = new PlayerRepository(application.getApplicationContext());
    }

    /* init function

     */
    public void init() {
        player = new Player();

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


    public void onSubmitButtonClick(){
        if (player.isValid()) {
            submitButtonClick.setValue(player);
            playerRepository.insertPlayer(player);
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
