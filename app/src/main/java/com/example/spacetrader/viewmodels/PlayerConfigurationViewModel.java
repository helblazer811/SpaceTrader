package com.example.spacetrader.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.spacetrader.dataaccess.DataAccessFacade;
import com.example.spacetrader.entities.Game;
import com.example.spacetrader.entities.GameDifficulty;
import com.example.spacetrader.entities.initializers.GameInitializer;
import com.example.spacetrader.entities.Player;

@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})
public class PlayerConfigurationViewModel extends ViewModel {

    private GameInitializer gameInitializer;
    private DataAccessFacade dataAccessFacade;

    private Player player;

    private View.OnFocusChangeListener onFocusName;
    private View.OnFocusChangeListener onFocusPoint;

    //Live data objects for the form data
    private MutableLiveData<Player> submitButtonClick = new MutableLiveData<>();

    public PlayerConfigurationViewModel() {
        super();
        gameInitializer = new GameInitializer();
        /*dataAccessFacade = DataAccessFacade.getInstance(
                getApplication().getApplicationContext());
        */
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
