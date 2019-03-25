package com.example.spacetrader.viewmodels.load;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.LoadItemBinding;
import com.example.spacetrader.entities.Player;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;

public class LoadAdapter extends BaseAdapter {

    private LiveData<List<Player>> players;
    private Activity activity;

    public LoadAdapter(Activity activity, LiveData<List<Player>> listPerson){
        this.players = players;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return players.getValue().size();
    }

    @Override
    public Object getItem(int position) {
        return players.getValue().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LoadItemBinding binding;
        if(convertView == null){
            convertView = LayoutInflater.from(activity).inflate(R.layout.load_item, null);
            binding = DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        }else{
            binding = (LoadItemBinding) convertView.getTag();
        }
        binding.setPlayer(players.getValue().get(position));
        return binding.getRoot();
    }
}
