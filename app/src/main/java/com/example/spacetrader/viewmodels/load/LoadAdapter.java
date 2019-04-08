package com.example.spacetrader.viewmodels.load;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.LoadItemBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.views.PlayerConfigurationActivity;
import com.example.spacetrader.views.maingame.MainActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;

/**
 * LoadAdapter of Space Trader
 */
public class LoadAdapter extends BaseAdapter {

    private final List<Player> players;
    private final Activity activity;
    private final Intent intent;

    /**
     * Creates LoadAdapter
     * @param activity game activity
     * @param listPerson list of Players
     * @param intent operation to be performed
     */
    public LoadAdapter(Activity activity, List<Player> listPerson, Intent intent){
        this.players = listPerson;
        this.activity = activity;
        this.intent = intent;
    }

    /**
     * Gets count of Players
     * @return Player size
     */
    @Override
    public int getCount() {
        return players.size();
    }

    /**
     * Gets item
     * @param position position of item
     * @return item
     */
    @Override
    public Object getItem(int position) {
        return players.get(position);
    }

    /**
     * Gets Item id
     * @param position position of item
     * @return 0
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Gets View of Load Adapter
     * @param position position of item
     * @param convertView old View reuse
     * @param parent parent of View
     * @return View of Load Adapter
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LoadItemBinding binding;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.load_item, null);
            binding = DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        } else {
            binding = (LoadItemBinding) convertView.getTag();
        }

        Button button = convertView.findViewById(R.id.load_item_button);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * If Button clicked, then player id is passed to intent to be pulled from next activity
             * @param v current View
             */
            @Override
            public void onClick(View v) {

                //pass the player id in the intent so it can be pulled from the next activity
                intent.putExtra("playerId", players.get(position).getPlayerId());
                activity.startActivity(intent);
            }
        });
        binding.setPlayer(players.get(position));
        return binding.getRoot();

    }
}
