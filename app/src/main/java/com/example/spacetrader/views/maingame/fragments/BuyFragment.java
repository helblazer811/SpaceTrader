package com.example.spacetrader.views.maingame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.FragmentBuyBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.viewmodels.BuyViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * defines operating parameters for buying; data binding
 */
public class BuyFragment extends Fragment {

    private BuyViewModel viewModel;

    /**
     * defines xml for fragment, sets up data binding, updates view
     * @param inflater used for layout
     * @param parent the view for the buy
     * @param savedInstanceState the bundle containing the state
     * @return the updated view
     */
    public View onCreateView(LayoutInflater inflater,final ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        //setup data binding here
        FragmentBuyBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_buy, parent, false);

        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(this).get(BuyViewModel.class);

        if (savedInstanceState == null) {
            long playerId = this.getArguments().getLong("playerId");
            viewModel.init(playerId, this);
        }

        binding.setViewmodel(viewModel);

        setupPurchaseButton(parent);

        binding.setLifecycleOwner(this);

        return view;
    }

    /**
     * sets up purchase button
     * @param parent the view for the purchase button
     */
    private void setupPurchaseButton(final ViewGroup parent) {
        viewModel.getPurchaseButtonClick().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player playerModel) {
                Toast.makeText(parent.getContext(),
                        playerModel.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }




}
